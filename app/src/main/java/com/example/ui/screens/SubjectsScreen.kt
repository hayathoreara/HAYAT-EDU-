package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.Chapter
import com.example.data.model.SubjectType
import com.example.data.repository.SyllabusRepository
import com.example.ui.theme.*

@Composable
fun SubjectsScreen(
    initialSubject: SubjectType? = null,
    completedChapters: Set<String>,
    onChapterClick: (Chapter) -> Unit,
    onOpenTrigChart: () -> Unit
) {
    var selectedSubject by remember(initialSubject) {
        mutableStateOf(initialSubject ?: SubjectType.MATHEMATICS)
    }

    val chapters = remember(selectedSubject) {
        SyllabusRepository.getChapters(selectedSubject)
    }

    val subjectColor = when (selectedSubject) {
        SubjectType.MATHEMATICS -> MathsBlue
        SubjectType.PHYSICS -> PhysicsPurple
        SubjectType.CHEMISTRY -> ChemistryGreen
    }

    val subjectGradient = when (selectedSubject) {
        SubjectType.MATHEMATICS -> MathsGradient
        SubjectType.PHYSICS -> PhysicsGradient
        SubjectType.CHEMISTRY -> ChemistryGradient
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .testTag("subjects_screen")
    ) {
        // Subject Selector Segmented Buttons / Tabs
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
                SubjectType.values().forEach { subject ->
                    val isSelected = selectedSubject == subject
                    val btnColor = when (subject) {
                        SubjectType.MATHEMATICS -> MathsBlue
                        SubjectType.PHYSICS -> PhysicsPurple
                        SubjectType.CHEMISTRY -> ChemistryGreen
                    }

                    FilterChip(
                        selected = isSelected,
                        onClick = { selectedSubject = subject },
                        label = {
                            Text(
                                text = subject.title,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                            )
                        },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = btnColor,
                            selectedLabelColor = Color.White
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .testTag("subject_tab_${subject.name.lowercase()}")
                    )
                }
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            contentPadding = PaddingValues(top = 12.dp, bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Subject Banner Card
            item {
                Card(
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(subjectGradient)
                            .padding(18.dp)
                    ) {
                        Column {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = selectedSubject.title,
                                    style = MaterialTheme.typography.headlineSmall.copy(
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    )
                                )

                                Surface(
                                    shape = RoundedCornerShape(8.dp),
                                    color = Color.White.copy(alpha = 0.2f)
                                ) {
                                    Text(
                                        text = "${chapters.size} Chapters",
                                        style = MaterialTheme.typography.labelMedium.copy(
                                            color = Color.White,
                                            fontWeight = FontWeight.SemiBold
                                        ),
                                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Comprehensive notes, exact formulas, worked examples & MCQs",
                                style = MaterialTheme.typography.bodySmall.copy(
                                    color = Color.White.copy(alpha = 0.9f)
                                )
                            )

                            // Special Trigonometry feature callout when on Maths
                            if (selectedSubject == SubjectType.MATHEMATICS) {
                                Spacer(modifier = Modifier.height(12.dp))
                                Button(
                                    onClick = onOpenTrigChart,
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color.White,
                                        contentColor = MathsBlue
                                    ),
                                    shape = RoundedCornerShape(12.dp),
                                    modifier = Modifier.testTag("open_trig_chart_banner_btn")
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.TableChart,
                                        contentDescription = null,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text("Open Full Trigonometry Chart & Identities", fontWeight = FontWeight.Bold, fontSize = 12.sp)
                                }
                            }
                        }
                    }
                }
            }

            // Chapter list items
            items(chapters) { chapter ->
                val isCompleted = completedChapters.contains(chapter.id)

                Card(
                    onClick = { onChapterClick(chapter) },
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("chapter_item_${chapter.id}")
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Number Circle
                        Box(
                            modifier = Modifier
                                .size(42.dp)
                                .clip(CircleShape)
                                .background(
                                    if (isCompleted) ChemistryGreen.copy(alpha = 0.15f)
                                    else subjectColor.copy(alpha = 0.12f)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            if (isCompleted) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "Completed",
                                    tint = ChemistryGreen,
                                    modifier = Modifier.size(20.dp)
                                )
                            } else {
                                Text(
                                    text = "${chapter.number}",
                                    fontWeight = FontWeight.Bold,
                                    color = subjectColor,
                                    fontSize = 16.sp
                                )
                            }
                        }

                        Spacer(modifier = Modifier.width(14.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Text(
                                    text = chapter.title,
                                    style = MaterialTheme.typography.titleMedium.copy(
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 16.sp
                                    ),
                                    color = MaterialTheme.colorScheme.onSurface,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = chapter.overview,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )

                            Spacer(modifier = Modifier.height(6.dp))

                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Surface(
                                    shape = RoundedCornerShape(4.dp),
                                    color = MaterialTheme.colorScheme.surfaceVariant
                                ) {
                                    Text(
                                        text = "${chapter.formulas.size} Formulas",
                                        style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.sp),
                                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                    )
                                }

                                Surface(
                                    shape = RoundedCornerShape(4.dp),
                                    color = MaterialTheme.colorScheme.surfaceVariant
                                ) {
                                    Text(
                                        text = "${chapter.mcqs.size} MCQs",
                                        style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.sp),
                                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                    )
                                }

                                if (isCompleted) {
                                    Surface(
                                        shape = RoundedCornerShape(4.dp),
                                        color = ChemistryGreen.copy(alpha = 0.1f)
                                    ) {
                                        Text(
                                            text = "Completed",
                                            style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.sp),
                                            color = ChemistryGreen,
                                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                        )
                                    }
                                }
                            }
                        }

                        IconButton(onClick = { onChapterClick(chapter) }) {
                            Icon(
                                imageVector = Icons.Default.ChevronRight,
                                contentDescription = "Open Chapter",
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }
        }
    }
}
