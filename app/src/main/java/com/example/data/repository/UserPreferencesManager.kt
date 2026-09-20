package com.example.data.repository

import android.content.Context
import android.content.SharedPreferences
import android.net.Uri
import com.example.data.model.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.io.FileOutputStream

class UserPreferencesManager(private val context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("abu_study_user_prefs", Context.MODE_PRIVATE)

    private val _userProfile = MutableStateFlow(loadProfile())
    val userProfile: StateFlow<UserProfile> = _userProfile.asStateFlow()

    private val _completedChapters = MutableStateFlow(loadCompletedChapters())
    val completedChapters: StateFlow<Set<String>> = _completedChapters.asStateFlow()

    private val _solvedQuestions = MutableStateFlow(loadSolvedQuestions())
    val solvedQuestions: StateFlow<Set<String>> = _solvedQuestions.asStateFlow()

    private val _bookmarks = MutableStateFlow(loadBookmarks())
    val bookmarks: StateFlow<List<BookmarkItem>> = _bookmarks.asStateFlow()

    private val _themeMode = MutableStateFlow(prefs.getString(KEY_THEME_MODE, "SYSTEM") ?: "SYSTEM")
    val themeMode: StateFlow<String> = _themeMode.asStateFlow()

    private val _lastStudiedChapterId = MutableStateFlow(prefs.getString(KEY_LAST_CHAPTER, "math_ch3") ?: "math_ch3")
    val lastStudiedChapterId: StateFlow<String> = _lastStudiedChapterId.asStateFlow()

    private val _recentActivities = MutableStateFlow(loadRecentActivities())
    val recentActivities: StateFlow<List<String>> = _recentActivities.asStateFlow()

    companion object {
        private const val KEY_PROFILE_NAME = "profile_name"
        private const val KEY_PROFILE_PHOTO = "profile_photo_path"
        private const val KEY_STREAK = "user_streak"
        private const val KEY_TOTAL_MINUTES = "total_study_minutes"
        private const val KEY_NOTIF_ENABLED = "notifications_enabled"
        private const val KEY_STUDY_GOAL = "study_goal_minutes"
        private const val KEY_COMPLETED_CHAPTERS = "completed_chapters_json"
        private const val KEY_SOLVED_QUESTIONS = "solved_questions_json"
        private const val KEY_BOOKMARKS = "bookmarks_json"
        private const val KEY_THEME_MODE = "theme_mode"
        private const val KEY_LAST_CHAPTER = "last_chapter_id"
        private const val KEY_RECENT_ACTIVITIES = "recent_activities_json"
    }

    private fun loadProfile(): UserProfile {
        val name = prefs.getString(KEY_PROFILE_NAME, "ABU HOREARA") ?: "ABU HOREARA"
        val photo = prefs.getString(KEY_PROFILE_PHOTO, null)
        val streak = prefs.getInt(KEY_STREAK, 7)
        val minutes = prefs.getInt(KEY_TOTAL_MINUTES, 540)
        val notif = prefs.getBoolean(KEY_NOTIF_ENABLED, true)
        val goal = prefs.getInt(KEY_STUDY_GOAL, 90)
        return UserProfile(name, photo, streak, minutes, notif, goal)
    }

    fun updateProfile(name: String, photoUri: Uri?, removePhoto: Boolean) {
        var photoPath = _userProfile.value.photoPath

        if (removePhoto) {
            photoPath?.let { path ->
                try {
                    val file = File(path)
                    if (file.exists()) file.delete()
                } catch (_: Exception) {}
            }
            photoPath = null
        } else if (photoUri != null) {
            try {
                val internalFile = File(context.filesDir, "abu_study_profile_${System.currentTimeMillis()}.jpg")
                context.contentResolver.openInputStream(photoUri)?.use { input ->
                    FileOutputStream(internalFile).use { output ->
                        input.copyTo(output)
                    }
                }
                photoPath = internalFile.absolutePath
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        val updated = _userProfile.value.copy(
            name = if (name.isNotBlank()) name.trim() else "ABU HOREARA",
            photoPath = photoPath
        )

        prefs.edit()
            .putString(KEY_PROFILE_NAME, updated.name)
            .putString(KEY_PROFILE_PHOTO, updated.photoPath)
            .apply()

        _userProfile.value = updated
        addActivity("Updated profile details")
    }

    fun setThemeMode(mode: String) {
        prefs.edit().putString(KEY_THEME_MODE, mode).apply()
        _themeMode.value = mode
    }

    fun setNotificationsEnabled(enabled: Boolean) {
        val updated = _userProfile.value.copy(notificationsEnabled = enabled)
        prefs.edit().putBoolean(KEY_NOTIF_ENABLED, enabled).apply()
        _userProfile.value = updated
    }

    fun toggleChapterCompleted(chapterId: String) {
        val current = _completedChapters.value.toMutableSet()
        val isNowCompleted: Boolean
        if (current.contains(chapterId)) {
            current.remove(chapterId)
            isNowCompleted = false
        } else {
            current.add(chapterId)
            isNowCompleted = true
        }
        val jsonArray = JSONArray()
        current.forEach { jsonArray.put(it) }
        prefs.edit().putString(KEY_COMPLETED_CHAPTERS, jsonArray.toString()).apply()
        _completedChapters.value = current

        val chapter = SyllabusRepository.getChapter(chapterId)
        val title = chapter?.title ?: "Chapter"
        if (isNowCompleted) {
            addActivity("Completed chapter: $title")
            // Add 30 minutes study time
            addStudyMinutes(30)
        } else {
            addActivity("Marked $title as in progress")
        }
    }

    fun markQuestionSolved(questionId: String, correct: Boolean) {
        val current = _solvedQuestions.value.toMutableSet()
        current.add(questionId)
        val jsonArray = JSONArray()
        current.forEach { jsonArray.put(it) }
        prefs.edit().putString(KEY_SOLVED_QUESTIONS, jsonArray.toString()).apply()
        _solvedQuestions.value = current

        if (correct) {
            addStudyMinutes(5)
        }
    }

    fun toggleBookmark(item: BookmarkItem): Boolean {
        val current = _bookmarks.value.toMutableList()
        val existingIndex = current.indexOfFirst { it.id == item.id }
        val isBookmarked: Boolean
        if (existingIndex >= 0) {
            current.removeAt(existingIndex)
            isBookmarked = false
            addActivity("Removed bookmark: ${item.title}")
        } else {
            current.add(0, item)
            isBookmarked = true
            addActivity("Bookmarked: ${item.title}")
        }
        saveBookmarks(current)
        _bookmarks.value = current
        return isBookmarked
    }

    fun removeBookmark(id: String) {
        val current = _bookmarks.value.toMutableList()
        current.removeAll { it.id == id }
        saveBookmarks(current)
        _bookmarks.value = current
    }

    fun isBookmarked(id: String): Boolean {
        return _bookmarks.value.any { it.id == id }
    }

    fun recordChapterVisit(chapterId: String) {
        prefs.edit().putString(KEY_LAST_CHAPTER, chapterId).apply()
        _lastStudiedChapterId.value = chapterId
        val chapter = SyllabusRepository.getChapter(chapterId)
        if (chapter != null) {
            addActivity("Studied ${chapter.subject.shortName}: ${chapter.title}")
        }
    }

    fun addStudyMinutes(minutes: Int) {
        val newMinutes = _userProfile.value.totalStudyMinutes + minutes
        val updated = _userProfile.value.copy(totalStudyMinutes = newMinutes)
        prefs.edit().putInt(KEY_TOTAL_MINUTES, newMinutes).apply()
        _userProfile.value = updated
    }

    fun addActivity(activity: String) {
        val current = _recentActivities.value.toMutableList()
        current.add(0, activity)
        val trimmed = current.take(10)
        val array = JSONArray()
        trimmed.forEach { array.put(it) }
        prefs.edit().putString(KEY_RECENT_ACTIVITIES, array.toString()).apply()
        _recentActivities.value = trimmed
    }

    private fun saveBookmarks(list: List<BookmarkItem>) {
        val array = JSONArray()
        for (b in list) {
            val obj = JSONObject().apply {
                put("id", b.id)
                put("type", b.type.name)
                put("title", b.title)
                put("subject", b.subject.name)
                put("subtitle", b.subtitle)
                put("content", b.content)
                put("chapterId", b.chapterId)
            }
            array.put(obj)
        }
        prefs.edit().putString(KEY_BOOKMARKS, array.toString()).apply()
    }

    private fun loadBookmarks(): List<BookmarkItem> {
        val raw = prefs.getString(KEY_BOOKMARKS, null) ?: return getDefaultBookmarks()
        val list = mutableListOf<BookmarkItem>()
        try {
            val array = JSONArray(raw)
            for (i in 0 until array.length()) {
                val obj = array.getJSONObject(i)
                val typeStr = obj.optString("type", BookmarkType.NOTE.name)
                val type = runCatching { BookmarkType.valueOf(typeStr) }.getOrDefault(BookmarkType.NOTE)
                val subjStr = obj.optString("subject", SubjectType.MATHEMATICS.name)
                val subj = runCatching { SubjectType.valueOf(subjStr) }.getOrDefault(SubjectType.MATHEMATICS)
                list.add(
                    BookmarkItem(
                        id = obj.getString("id"),
                        type = type,
                        title = obj.getString("title"),
                        subject = subj,
                        subtitle = obj.optString("subtitle", ""),
                        content = obj.optString("content", ""),
                        chapterId = obj.optString("chapterId", "")
                    )
                )
            }
        } catch (_: Exception) {
            return getDefaultBookmarks()
        }
        return list
    }

    private fun getDefaultBookmarks(): List<BookmarkItem> {
        return listOf(
            BookmarkItem(
                id = "bm_trig_identities",
                type = BookmarkType.FORMULA,
                title = "Pythagorean & Double Angle Identities",
                subject = SubjectType.MATHEMATICS,
                subtitle = "Trigonometric Functions",
                content = "sin²θ + cos²θ = 1, sin 2A = 2 sin A cos A",
                chapterId = "math_ch3"
            ),
            BookmarkItem(
                id = "bm_bernoulli",
                type = BookmarkType.FORMULA,
                title = "Bernoulli's Equation",
                subject = SubjectType.PHYSICS,
                subtitle = "Mechanical Properties of Fluids",
                content = "P + 1/2 ρv² + ρgh = constant",
                chapterId = "phy_ch9"
            ),
            BookmarkItem(
                id = "bm_mot",
                type = BookmarkType.NOTE,
                title = "Molecular Orbital Theory & Bond Order",
                subject = SubjectType.CHEMISTRY,
                subtitle = "Chemical Bonding",
                content = "Bond Order = 1/2(Nb - Na). O2 is paramagnetic with 2 unpaired electrons.",
                chapterId = "chem_ch4"
            )
        )
    }

    private fun loadCompletedChapters(): Set<String> {
        val raw = prefs.getString(KEY_COMPLETED_CHAPTERS, null) ?: return setOf("math_ch1", "phy_ch1", "chem_ch1")
        val set = mutableSetOf<String>()
        try {
            val array = JSONArray(raw)
            for (i in 0 until array.length()) {
                set.add(array.getString(i))
            }
        } catch (_: Exception) {
            return setOf("math_ch1", "phy_ch1", "chem_ch1")
        }
        return set
    }

    private fun loadSolvedQuestions(): Set<String> {
        val raw = prefs.getString(KEY_SOLVED_QUESTIONS, null) ?: return setOf("m1_1", "p1_1", "c1_1")
        val set = mutableSetOf<String>()
        try {
            val array = JSONArray(raw)
            for (i in 0 until array.length()) {
                set.add(array.getString(i))
            }
        } catch (_: Exception) {
            return setOf("m1_1", "p1_1", "c1_1")
        }
        return set
    }

    private fun loadRecentActivities(): List<String> {
        val raw = prefs.getString(KEY_RECENT_ACTIVITIES, null)
        if (raw == null) {
            return listOf(
                "Solved 5 Practice MCQs in Trigonometry",
                "Reviewed Kinematics formulas",
                "Achieved 7-day study streak"
            )
        }
        val list = mutableListOf<String>()
        try {
            val array = JSONArray(raw)
            for (i in 0 until array.length()) {
                list.add(array.getString(i))
            }
        } catch (_: Exception) {
            return listOf("Started studying Class 11 Syllabus")
        }
        return list
    }
}
