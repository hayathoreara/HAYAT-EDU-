package com.example.ui

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.data.model.SubjectType
import com.example.ui.components.AbuBottomNavBar
import com.example.ui.components.AbuTopAppBar
import com.example.ui.components.GlobalSearchDialog
import com.example.ui.screens.*
import com.example.ui.theme.AbuStudyTheme
import com.example.ui.viewmodel.AbuStudyViewModel
import com.example.ui.viewmodel.AppTab

@Composable
fun AbuStudyApp(
    viewModel: AbuStudyViewModel = viewModel()
) {
    val userProfile by viewModel.userProfile.collectAsState()
    val completedChapters by viewModel.completedChapters.collectAsState()
    val solvedQuestions by viewModel.solvedQuestions.collectAsState()
    val bookmarks by viewModel.bookmarks.collectAsState()
    val themeMode by viewModel.themeMode.collectAsState()
    val currentTab by viewModel.currentTab.collectAsState()
    val selectedChapter by viewModel.selectedChapter.collectAsState()
    val showTrigChart by viewModel.showTrigChart.collectAsState()
    val showSettings by viewModel.showSettings.collectAsState()
    val showProgress by viewModel.showProgress.collectAsState()
    val isSearchActive by viewModel.isSearchActive.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    val searchResults by viewModel.searchResults.collectAsState()
    val quizState by viewModel.quizState.collectAsState()
    val lastStudiedChapterId by viewModel.lastStudiedChapterId.collectAsState()
    val recentActivities by viewModel.recentActivities.collectAsState()

    // Back handling
    BackHandler(
        enabled = selectedChapter != null || showTrigChart || showSettings || showProgress || isSearchActive
    ) {
        when {
            isSearchActive -> viewModel.setSearchActive(false)
            selectedChapter != null -> viewModel.closeChapter()
            showTrigChart -> viewModel.closeTrigChart()
            showProgress -> viewModel.closeProgressDashboard()
            showSettings -> viewModel.closeSettings()
        }
    }

    AbuStudyTheme(themePreference = themeMode) {
        Scaffold(
            topBar = {
                // Show top app bar only when not in a full screen sub-view (which has its own TopAppBar)
                if (selectedChapter == null && !showTrigChart && !showSettings && !showProgress) {
                    AbuTopAppBar(
                        title = "HAYAT EDU",
                        onSearchClick = { viewModel.setSearchActive(true) },
                        onSettingsClick = { viewModel.openSettings() }
                    )
                }
            },
            bottomBar = {
                // Show bottom navigation bar on primary tabs
                if (selectedChapter == null && !showTrigChart && !showSettings && !showProgress) {
                    AbuBottomNavBar(
                        currentTab = currentTab,
                        onTabSelected = { viewModel.selectTab(it) }
                    )
                }
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                // Sub-screens
                when {
                    showSettings -> {
                        SettingsScreen(
                            currentThemeMode = themeMode,
                            notificationsEnabled = userProfile.notificationsEnabled,
                            onSetThemeMode = { viewModel.setThemeMode(it) },
                            onToggleNotifications = { viewModel.setNotificationsEnabled(it) },
                            onBack = { viewModel.closeSettings() }
                        )
                    }

                    showProgress -> {
                        ProgressDashboardScreen(
                            userProfile = userProfile,
                            completedChapters = completedChapters,
                            onToggleChapter = { viewModel.toggleChapterCompleted(it) },
                            onBack = { viewModel.closeProgressDashboard() }
                        )
                    }

                    showTrigChart -> {
                        TrigonometryScreen(
                            onBack = { viewModel.closeTrigChart() },
                            onSaveBookmark = { viewModel.toggleBookmark(it) }
                        )
                    }

                    selectedChapter != null -> {
                        val ch = selectedChapter!!
                        ChapterDetailScreen(
                            chapter = ch,
                            isCompleted = completedChapters.contains(ch.id),
                            isBookmarked = viewModel.isBookmarked("chapter_${ch.id}"),
                            onBack = { viewModel.closeChapter() },
                            onToggleCompleted = { viewModel.toggleChapterCompleted(ch.id) },
                            onToggleBookmark = { viewModel.toggleBookmark(it) },
                            onOpenTrigChart = { viewModel.openTrigChart() }
                        )
                    }

                    else -> {
                        // Main Tab Views
                        AnimatedContent(
                            targetState = currentTab,
                            transitionSpec = { fadeIn() togetherWith fadeOut() },
                            label = "tab_transition"
                        ) { tab ->
                            when (tab) {
                                AppTab.HOME -> {
                                    HomeScreen(
                                        userProfile = userProfile,
                                        completedChapters = completedChapters,
                                        solvedQuestions = solvedQuestions,
                                        bookmarksCount = bookmarks.size,
                                        lastStudiedChapterId = lastStudiedChapterId,
                                        recentActivities = recentActivities,
                                        onOpenChapter = { viewModel.openChapter(it) },
                                        onNavigateTab = { viewModel.selectTab(it) },
                                        onOpenProgress = { viewModel.openProgressDashboard() },
                                        onOpenTrigChart = { viewModel.openTrigChart() },
                                        onOpenSubject = { subject ->
                                            viewModel.selectTab(AppTab.SUBJECTS)
                                            viewModel.setSubjectFilter(subject)
                                        },
                                        onAvatarClick = { viewModel.selectTab(AppTab.PROFILE) }
                                    )
                                }

                                AppTab.SUBJECTS -> {
                                    SubjectsScreen(
                                        initialSubject = viewModel.selectedSubjectFilter.value,
                                        completedChapters = completedChapters,
                                        onChapterClick = { viewModel.openChapter(it) },
                                        onOpenTrigChart = { viewModel.openTrigChart() }
                                    )
                                }

                                AppTab.PRACTICE -> {
                                    PracticeScreen(
                                        quizState = quizState,
                                        onSelectSubject = { viewModel.initQuiz(it) },
                                        onSelectOption = { viewModel.selectQuizOption(it) },
                                        onSubmitAnswer = { viewModel.submitQuizAnswer() },
                                        onNextQuestion = { viewModel.nextQuizQuestion() },
                                        onRetry = { viewModel.retryQuiz() }
                                    )
                                }

                                AppTab.BOOKMARKS -> {
                                    BookmarksScreen(
                                        bookmarks = bookmarks,
                                        onOpenChapterId = { viewModel.openChapterById(it) },
                                        onRemoveBookmark = { viewModel.removeBookmark(it) }
                                    )
                                }

                                AppTab.PROFILE -> {
                                    ProfileScreen(
                                        userProfile = userProfile,
                                        completedChaptersCount = completedChapters.size,
                                        solvedQuestionsCount = solvedQuestions.size,
                                        bookmarksCount = bookmarks.size,
                                        onUpdateProfile = { name, uri, removePhoto ->
                                            viewModel.updateProfile(name, uri, removePhoto)
                                        },
                                        onOpenProgress = { viewModel.openProgressDashboard() },
                                        onOpenSettings = { viewModel.openSettings() }
                                    )
                                }
                            }
                        }
                    }
                }

                // Global Search Overlay Dialog
                if (isSearchActive) {
                    GlobalSearchDialog(
                        query = searchQuery,
                        results = searchResults,
                        onQueryChanged = { viewModel.onSearchQueryChanged(it) },
                        onResultSelected = { result ->
                            viewModel.setSearchActive(false)
                            viewModel.openChapterById(result.chapterId)
                        },
                        onDismiss = { viewModel.setSearchActive(false) }
                    )
                }
            }
        }
    }
}
