package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.SubjectType
import com.example.data.model.UserProfile
import com.example.data.repository.SyllabusRepository
import com.example.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProgressDashboardScreen(
    userProfile: UserProfile,
    completedChapters: Set<String>,
    onToggleChapter: (String) -> Unit,
    onBack: () -> Unit
) {
    val mathChapters = SyllabusRepository.getChapters(SubjectType.MATHEMATICS)
    val phyChapters = SyllabusRepository.getChapters(SubjectType.PHYSICS)
    val chemChapters = SyllabusRepository.getChapters(SubjectType.CHEMISTRY)

    val mathCompleted = mathChapters.count { completedChapters.contains(it.id) }
    val phyCompleted = phyChapters.count { completedChapters.contains(it.id) }
    val chemCompleted = chemChapters.count { completedChapters.contains(it.id) }

    val totalCompleted = completedChapters.size
    val totalChapters = SyllabusRepository.allChapters.size
    val overallPercent = if (totalChapters > 0) (totalCompleted.toFloat() / totalChapters * 100).toInt() else 0

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Study Progress Dashboard",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBack, modifier = Modifier.testTag("progress_back_button")) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            contentPadding = PaddingValues(top = 16.dp, bottom = 32.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            // Big Circular Progress / Banner Card
            item {
                Card(
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Class 11 Syllabus Completion",
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.size(130.dp)
                        ) {
                            CircularProgressIndicator(
                                progress = { overallPercent / 100f },
                                modifier = Modifier.size(120.dp),
                                color = MaterialTheme.colorScheme.primary,
                                trackColor = MaterialTheme.colorScheme.surfaceVariant,
                                strokeWidth = 10.dp
                            )
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = "$overallPercent%",
                                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = "$totalCompleted / $totalChapters Done",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.LocalFireDepartment, contentDescription = null, tint = AmberStreak)
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("${userProfile.streakDays}d Streak", fontWeight = FontWeight.SemiBold)
                            }
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.Timer, contentDescription = null, tint = ChemistryGreen)
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("${userProfile.totalStudyMinutes / 60}h Studied", fontWeight = FontWeight.SemiBold)
                            }
                        }
                    }
                }
            }

            // Subject-wise Breakdown
            item {
                Text(
                    text = "Subject-Wise Progress",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier = Modifier.height(10.dp))

                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    SubjectProgressBar(
                        title = "Mathematics",
                        completed = mathCompleted,
                        total = mathChapters.size,
                        color = MathsBlue
                    )
                    SubjectProgressBar(
                        title = "Physics",
                        completed = phyCompleted,
                        total = phyChapters.size,
                        color = PhysicsPurple
                    )
                    SubjectProgressBar(
                        title = "Chemistry",
                        completed = chemCompleted,
                        total = chemChapters.size,
                        color = ChemistryGreen
                    )
                }
            }

            // Chapter Checklist Section
            item {
                Text(
                    text = "All Chapters Checklist (Tap to toggle)",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            items(SyllabusRepository.allChapters) { ch ->
                val isDone = completedChapters.contains(ch.id)
                val subjColor = when (ch.subject) {
                    SubjectType.MATHEMATICS -> MathsBlue
                    SubjectType.PHYSICS -> PhysicsPurple
                    SubjectType.CHEMISTRY -> ChemistryGreen
                }

                Card(
                    onClick = { onToggleChapter(ch.id) },
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Checkbox(
                                checked = isDone,
                                onCheckedChange = { onToggleChapter(ch.id) },
                                colors = CheckboxDefaults.colors(checkedColor = ChemistryGreen)
                            )

                            Column {
                                Text(
                                    text = "Ch ${ch.number}: ${ch.title}",
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        fontWeight = FontWeight.SemiBold
                                    ),
                                    color = if (isDone) MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f) else MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = ch.subject.title,
                                    style = MaterialTheme.typography.labelSmall,
                                    color = subjColor
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SubjectProgressBar(
    title: String,
    completed: Int,
    total: Int,
    color: Color
) {
    val percent = if (total > 0) (completed.toFloat() / total * 100).toInt() else 0

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                    color = color
                )
                Text(
                    text = "$completed / $total chapters ($percent%)",
                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.SemiBold),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            LinearProgressIndicator(
                progress = { percent / 100f },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .clip(RoundedCornerShape(4.dp)),
                color = color,
                trackColor = MaterialTheme.colorScheme.surfaceVariant
            )
        }
    }
}
