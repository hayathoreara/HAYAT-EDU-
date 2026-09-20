package com.example.ui.viewmodel

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.model.*
import com.example.data.repository.SyllabusRepository
import com.example.data.repository.UserPreferencesManager
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

enum class AppTab(val title: String) {
    HOME("Home"),
    SUBJECTS("Subjects"),
    PRACTICE("Practice"),
    BOOKMARKS("Bookmarks"),
    PROFILE("Profile")
}

data class QuizUiState(
    val questions: List<McqQuestion> = emptyList(),
    val currentIndex: Int = 0,
    val selectedOptionIndex: Int? = null,
    val isSubmitted: Boolean = false,
    val score: Int = 0,
    val isFinished: Boolean = false,
    val filterSubject: SubjectType? = null
)

class AbuStudyViewModel(application: Application) : AndroidViewModel(application) {
    private val prefsManager = UserPreferencesManager(application)

    val userProfile: StateFlow<UserProfile> = prefsManager.userProfile
    val completedChapters: StateFlow<Set<String>> = prefsManager.completedChapters
    val solvedQuestions: StateFlow<Set<String>> = prefsManager.solvedQuestions
    val bookmarks: StateFlow<List<BookmarkItem>> = prefsManager.bookmarks
    val themeMode: StateFlow<String> = prefsManager.themeMode
    val lastStudiedChapterId: StateFlow<String> = prefsManager.lastStudiedChapterId
    val recentActivities: StateFlow<List<String>> = prefsManager.recentActivities

    private val _currentTab = MutableStateFlow(AppTab.HOME)
    val currentTab: StateFlow<AppTab> = _currentTab.asStateFlow()

    private val _selectedChapter = MutableStateFlow<Chapter?>(null)
    val selectedChapter: StateFlow<Chapter?> = _selectedChapter.asStateFlow()

    private val _showTrigChart = MutableStateFlow(false)
    val showTrigChart: StateFlow<Boolean> = _showTrigChart.asStateFlow()

    private val _showSettings = MutableStateFlow(false)
    val showSettings: StateFlow<Boolean> = _showSettings.asStateFlow()

    private val _showProgress = MutableStateFlow(false)
    val showProgress: StateFlow<Boolean> = _showProgress.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _searchResults = MutableStateFlow<List<SearchResult>>(emptyList())
    val searchResults: StateFlow<List<SearchResult>> = _searchResults.asStateFlow()

    private val _isSearchActive = MutableStateFlow(false)
    val isSearchActive: StateFlow<Boolean> = _isSearchActive.asStateFlow()

    private val _selectedSubjectFilter = MutableStateFlow<SubjectType?>(null)
    val selectedSubjectFilter: StateFlow<SubjectType?> = _selectedSubjectFilter.asStateFlow()

    // Interactive Quiz State
    private val _quizState = MutableStateFlow(QuizUiState())
    val quizState: StateFlow<QuizUiState> = _quizState.asStateFlow()

    init {
        initQuiz(null)
    }

    fun selectTab(tab: AppTab) {
        _currentTab.value = tab
        _selectedChapter.value = null
        _showTrigChart.value = false
        _showSettings.value = false
        _showProgress.value = false
        _isSearchActive.value = false
    }

    fun openChapter(chapter: Chapter) {
        _selectedChapter.value = chapter
        prefsManager.recordChapterVisit(chapter.id)
    }

    fun openChapterById(id: String) {
        val ch = SyllabusRepository.getChapter(id)
        if (ch != null) {
            _selectedChapter.value = ch
            prefsManager.recordChapterVisit(id)
            _isSearchActive.value = false
        }
    }

    fun closeChapter() {
        _selectedChapter.value = null
    }

    fun openTrigChart() {
        _showTrigChart.value = true
    }

    fun closeTrigChart() {
        _showTrigChart.value = false
    }

    fun openSettings() {
        _showSettings.value = true
    }

    fun closeSettings() {
        _showSettings.value = false
    }

    fun openProgressDashboard() {
        _showProgress.value = true
    }

    fun closeProgressDashboard() {
        _showProgress.value = false
    }

    fun setSearchActive(active: Boolean) {
        _isSearchActive.value = active
        if (!active) {
            _searchQuery.value = ""
            _searchResults.value = emptyList()
        }
    }

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
        if (query.isBlank()) {
            _searchResults.value = emptyList()
        } else {
            _searchResults.value = SyllabusRepository.searchAll(query)
        }
    }

    fun setSubjectFilter(subject: SubjectType?) {
        _selectedSubjectFilter.value = subject
    }

    fun updateProfile(name: String, photoUri: Uri?, removePhoto: Boolean) {
        prefsManager.updateProfile(name, photoUri, removePhoto)
    }

    fun toggleChapterCompleted(chapterId: String) {
        prefsManager.toggleChapterCompleted(chapterId)
    }

    fun isChapterCompleted(chapterId: String): Boolean {
        return completedChapters.value.contains(chapterId)
    }

    fun toggleBookmark(item: BookmarkItem): Boolean {
        return prefsManager.toggleBookmark(item)
    }

    fun removeBookmark(id: String) {
        prefsManager.removeBookmark(id)
    }

    fun isBookmarked(id: String): Boolean {
        return prefsManager.isBookmarked(id)
    }

    fun setThemeMode(mode: String) {
        prefsManager.setThemeMode(mode)
    }

    fun setNotificationsEnabled(enabled: Boolean) {
        prefsManager.setNotificationsEnabled(enabled)
    }

    // Quiz functions
    fun initQuiz(subject: SubjectType?) {
        val list = SyllabusRepository.getAllMcqs(subject).shuffled()
        _quizState.value = QuizUiState(
            questions = list,
            currentIndex = 0,
            selectedOptionIndex = null,
            isSubmitted = false,
            score = 0,
            isFinished = false,
            filterSubject = subject
        )
    }

    fun selectQuizOption(index: Int) {
        if (!_quizState.value.isSubmitted) {
            _quizState.value = _quizState.value.copy(selectedOptionIndex = index)
        }
    }

    fun submitQuizAnswer() {
        val current = _quizState.value
        val option = current.selectedOptionIndex ?: return
        if (current.isSubmitted) return

        val q = current.questions.getOrNull(current.currentIndex) ?: return
        val isCorrect = option == q.correctOptionIndex
        val newScore = if (isCorrect) current.score + 1 else current.score

        prefsManager.markQuestionSolved(q.id, isCorrect)

        _quizState.value = current.copy(
            isSubmitted = true,
            score = newScore
        )
    }

    fun nextQuizQuestion() {
        val current = _quizState.value
        if (current.currentIndex + 1 < current.questions.size) {
            _quizState.value = current.copy(
                currentIndex = current.currentIndex + 1,
                selectedOptionIndex = null,
                isSubmitted = false
            )
        } else {
            _quizState.value = current.copy(isFinished = true)
        }
    }

    fun retryQuiz() {
        initQuiz(_quizState.value.filterSubject)
    }
}
