package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.SubjectType
import com.example.ui.theme.*
import com.example.ui.viewmodel.QuizUiState

@Composable
fun PracticeScreen(
    quizState: QuizUiState,
    onSelectSubject: (SubjectType?) -> Unit,
    onSelectOption: (Int) -> Unit,
    onSubmitAnswer: () -> Unit,
    onNextQuestion: () -> Unit,
    onRetry: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .testTag("practice_screen")
    ) {
        // Subject Filter Bar
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.surface,
            tonalElevation = 2.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                FilterChip(
                    selected = quizState.filterSubject == null,
                    onClick = { onSelectSubject(null) },
                    label = { Text("All Subjects") }
                )
                FilterChip(
                    selected = quizState.filterSubject == SubjectType.MATHEMATICS,
                    onClick = { onSelectSubject(SubjectType.MATHEMATICS) },
                    label = { Text("Maths") }
                )
                FilterChip(
                    selected = quizState.filterSubject == SubjectType.PHYSICS,
                    onClick = { onSelectSubject(SubjectType.PHYSICS) },
                    label = { Text("Physics") }
                )
                FilterChip(
                    selected = quizState.filterSubject == SubjectType.CHEMISTRY,
                    onClick = { onSelectSubject(SubjectType.CHEMISTRY) },
                    label = { Text("Chemistry") }
                )
            }
        }

        if (quizState.questions.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "No questions available for this filter.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            return
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            contentPadding = PaddingValues(top = 16.dp, bottom = 32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            if (quizState.isFinished) {
                item {
                    QuizFinishedCard(
                        score = quizState.score,
                        total = quizState.questions.size,
                        onRetry = onRetry
                    )
                }
            } else {
                val currentQuestion = quizState.questions[quizState.currentIndex]
                val currentSubject = currentQuestion.subject
                val subjectColor = when (currentSubject) {
                    SubjectType.MATHEMATICS -> MathsBlue
                    SubjectType.PHYSICS -> PhysicsPurple
                    SubjectType.CHEMISTRY -> ChemistryGreen
                }

                // Header / Question Counter & Progress
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "Question ${quizState.currentIndex + 1} of ${quizState.questions.size}",
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "${currentSubject.title} • ${currentQuestion.chapterTitle}",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = MaterialTheme.colorScheme.primaryContainer
                        ) {
                            Text(
                                text = "Score: ${quizState.score}",
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary
                                ),
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    LinearProgressIndicator(
                        progress = { (quizState.currentIndex + 1).toFloat() / quizState.questions.size },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(6.dp)
                            .clip(RoundedCornerShape(3.dp)),
                        color = subjectColor,
                        trackColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                }

                // Question Box
                item {
                    Card(
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(18.dp)) {
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = subjectColor.copy(alpha = 0.12f)
                            ) {
                                Text(
                                    text = currentQuestion.chapterTitle.uppercase(),
                                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                                    color = subjectColor,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                )
                            }

                            Spacer(modifier = Modifier.height(12.dp))

                            Text(
                                text = currentQuestion.question,
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.SemiBold,
                                    lineHeight = 24.sp
                                ),
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }

                // Options List
                items(currentQuestion.options.size) { index ->
                    val optionText = currentQuestion.options[index]
                    val isSelected = quizState.selectedOptionIndex == index
                    val isSubmitted = quizState.isSubmitted
                    val isCorrectOption = index == currentQuestion.correctOptionIndex

                    val borderColor: Color
                    val containerColor: Color
                    val textColor: Color

                    if (isSubmitted) {
                        if (isCorrectOption) {
                            borderColor = ChemistryGreen
                            containerColor = ChemistryGreen.copy(alpha = 0.15f)
                            textColor = ChemistryGreen
                        } else if (isSelected) {
                            borderColor = RoseHighlight
                            containerColor = RoseHighlight.copy(alpha = 0.15f)
                            textColor = RoseHighlight
                        } else {
                            borderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)
                            containerColor = MaterialTheme.colorScheme.surface
                            textColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                        }
                    } else {
                        if (isSelected) {
                            borderColor = subjectColor
                            containerColor = subjectColor.copy(alpha = 0.12f)
                            textColor = subjectColor
                        } else {
                            borderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)
                            containerColor = MaterialTheme.colorScheme.surface
                            textColor = MaterialTheme.colorScheme.onSurface
                        }
                    }

                    Card(
                        onClick = { onSelectOption(index) },
                        shape = RoundedCornerShape(14.dp),
                        colors = CardDefaults.cardColors(containerColor = containerColor),
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(1.5.dp, borderColor, RoundedCornerShape(14.dp))
                            .testTag("quiz_option_$index")
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(32.dp)
                                    .clip(CircleShape)
                                    .background(borderColor.copy(alpha = 0.2f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "${('A' + index)}",
                                    fontWeight = FontWeight.Bold,
                                    color = borderColor
                                )
                            }

                            Spacer(modifier = Modifier.width(12.dp))

                            Text(
                                text = optionText,
                                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                                color = textColor,
                                modifier = Modifier.weight(1f)
                            )

                            if (isSubmitted) {
                                if (isCorrectOption) {
                                    Icon(
                                        imageVector = Icons.Default.CheckCircle,
                                        contentDescription = "Correct",
                                        tint = ChemistryGreen
                                    )
                                } else if (isSelected) {
                                    Icon(
                                        imageVector = Icons.Default.Cancel,
                                        contentDescription = "Incorrect",
                                        tint = RoseHighlight
                                    )
                                }
                            }
                        }
                    }
                }

                // Explanation & Action Buttons
                item {
                    if (quizState.isSubmitted) {
                        Card(
                            shape = RoundedCornerShape(16.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        imageVector = Icons.Default.Info,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.primary,
                                        modifier = Modifier.size(18.dp)
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(
                                        text = "Explanation",
                                        style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                }
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = currentQuestion.explanation,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Button(
                            onClick = onNextQuestion,
                            shape = RoundedCornerShape(14.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .testTag("quiz_next_button")
                        ) {
                            Text(
                                text = if (quizState.currentIndex + 1 < quizState.questions.size) "Next Question" else "See Quiz Results",
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
                        }
                    } else {
                        Button(
                            onClick = onSubmitAnswer,
                            enabled = quizState.selectedOptionIndex != null,
                            shape = RoundedCornerShape(14.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .testTag("quiz_submit_button")
                        ) {
                            Text(
                                text = "Submit Answer",
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun QuizFinishedCard(
    score: Int,
    total: Int,
    onRetry: () -> Unit
) {
    val percentage = if (total > 0) (score.toFloat() / total * 100).toInt() else 0

    Card(
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        modifier = Modifier
            .fillMaxWidth()
            .testTag("quiz_results_card")
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .background(ChemistryGreen.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.EmojiEvents,
                    contentDescription = "Trophy",
                    tint = AmberStreak,
                    modifier = Modifier.size(44.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Quiz Completed!",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "You scored $score out of $total questions ($percentage%)",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = onRetry,
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Icon(imageVector = Icons.Default.Refresh, contentDescription = null)
                Spacer(modifier = Modifier.width(6.dp))
                Text("Practice Again", fontWeight = FontWeight.Bold)
            }
        }
    }
}
