package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.BookmarkItem
import com.example.data.model.BookmarkType
import com.example.data.model.SubjectType
import com.example.data.repository.TrigValueRow
import com.example.data.repository.TrigonometryData
import com.example.ui.theme.AmberStreak
import com.example.ui.theme.MathsBlue
import com.example.ui.theme.MathsGradient

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrigonometryScreen(
    onBack: () -> Unit,
    onSaveBookmark: (BookmarkItem) -> Unit
) {
    var selectedAngleIndex by remember { mutableStateOf(2) } // default 45°
    val selectedRow: TrigValueRow = TrigonometryData.tableValues.getOrElse(selectedAngleIndex) {
        TrigonometryData.tableValues.first()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Trigonometric Chart & Identities",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBack, modifier = Modifier.testTag("trig_back_button")) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            contentPadding = PaddingValues(top = 12.dp, bottom = 32.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            // Header Card
            item {
                Card(
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MathsGradient)
                            .padding(18.dp)
                    ) {
                        Column {
                            Text(
                                text = "Comprehensive Trigonometry Reference",
                                style = MaterialTheme.typography.titleLarge.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Standard angles 0° to 360°, radian measures, and fundamental identities for Class 11",
                                style = MaterialTheme.typography.bodySmall.copy(
                                    color = Color.White.copy(alpha = 0.9f)
                                )
                            )
                        }
                    }
                }
            }

            // Interactive Angle Selector Card
            item {
                Card(
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Interactive Angle Value Lookup",
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier.height(10.dp))

                        // Horizontal Scroll of standard angles
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(rememberScrollState()),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            TrigonometryData.tableValues.forEachIndexed { index, row ->
                                val isSelected = selectedAngleIndex == index
                                FilterChip(
                                    selected = isSelected,
                                    onClick = { selectedAngleIndex = index },
                                    label = {
                                        Text(
                                            text = "${row.angleDeg} (${row.angleRad})",
                                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                                        )
                                    },
                                    colors = FilterChipDefaults.filterChipColors(
                                        selectedContainerColor = MathsBlue,
                                        selectedLabelColor = Color.White
                                    )
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        // Grid of 6 trig functions for selected angle
                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                TrigValuePill("sin θ", selectedRow.sinVal, Modifier.weight(1f))
                                TrigValuePill("cos θ", selectedRow.cosVal, Modifier.weight(1f))
                                TrigValuePill("tan θ", selectedRow.tanVal, Modifier.weight(1f))
                            }
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                TrigValuePill("cosec θ", selectedRow.cscVal, Modifier.weight(1f))
                                TrigValuePill("sec θ", selectedRow.secVal, Modifier.weight(1f))
                                TrigValuePill("cot θ", selectedRow.cotVal, Modifier.weight(1f))
                            }
                        }
                    }
                }
            }

            // Complete Matrix Table Card
            item {
                Card(
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Complete Trigonometric Values Matrix",
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Scroll horizontally to inspect full values across all quadrants",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(rememberScrollState())
                        ) {
                            Column {
                                // Header row
                                Row(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(MaterialTheme.colorScheme.primaryContainer)
                                        .padding(vertical = 8.dp, horizontal = 4.dp)
                                ) {
                                    TableCell("Angle", 70, isHeader = true)
                                    TableCell("Rad", 60, isHeader = true)
                                    TableCell("sin", 65, isHeader = true)
                                    TableCell("cos", 65, isHeader = true)
                                    TableCell("tan", 65, isHeader = true)
                                    TableCell("cot", 65, isHeader = true)
                                    TableCell("sec", 65, isHeader = true)
                                    TableCell("cosec", 65, isHeader = true)
                                }

                                TrigonometryData.tableValues.forEachIndexed { i, row ->
                                    val rowBg = if (i % 2 == 0) Color.Transparent else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                                    Row(
                                        modifier = Modifier
                                            .background(rowBg)
                                            .padding(vertical = 8.dp, horizontal = 4.dp)
                                    ) {
                                        TableCell(row.angleDeg, 70, bold = true)
                                        TableCell(row.angleRad, 60)
                                        TableCell(row.sinVal, 65)
                                        TableCell(row.cosVal, 65)
                                        TableCell(row.tanVal, 65)
                                        TableCell(row.cotVal, 65)
                                        TableCell(row.secVal, 65)
                                        TableCell(row.cscVal, 65)
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // Trigonometric Identity Groups
            item {
                Text(
                    text = "Trigonometric Identities & Transformations",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            items(TrigonometryData.identityGroups) { group ->
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = group.category,
                                style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                                color = MathsBlue
                            )

                            IconButton(
                                onClick = {
                                    val contentText = group.formulas.joinToString("\n") { "${it.first} : ${it.second}" }
                                    onSaveBookmark(
                                        BookmarkItem(
                                            id = "trig_group_${group.category.hashCode()}",
                                            type = BookmarkType.FORMULA,
                                            title = group.category,
                                            subject = SubjectType.MATHEMATICS,
                                            subtitle = "Trigonometric Identities",
                                            content = contentText,
                                            chapterId = "math_ch3"
                                        )
                                    )
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.BookmarkBorder,
                                    contentDescription = "Save Formulas",
                                    tint = AmberStreak
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        group.formulas.forEach { (formula, notes) ->
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = MaterialTheme.colorScheme.surfaceVariant,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp)
                            ) {
                                Column(modifier = Modifier.padding(10.dp)) {
                                    Text(
                                        text = formula,
                                        style = MaterialTheme.typography.bodyMedium.copy(
                                            fontFamily = FontFamily.Monospace,
                                            fontWeight = FontWeight.SemiBold,
                                            color = MathsBlue
                                        )
                                    )
                                    if (notes.isNotBlank()) {
                                        Spacer(modifier = Modifier.height(2.dp))
                                        Text(
                                            text = notes,
                                            style = MaterialTheme.typography.bodySmall.copy(fontSize = 11.sp),
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TrigValuePill(name: String, value: String, modifier: Modifier = Modifier) {
    Surface(
        shape = RoundedCornerShape(10.dp),
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = value,
                style = MaterialTheme.typography.titleSmall.copy(
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace,
                    color = MathsBlue
                )
            )
        }
    }
}

@Composable
fun TableCell(text: String, width: Int, bold: Boolean = false, isHeader: Boolean = false) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodySmall.copy(
            fontWeight = if (isHeader || bold) FontWeight.Bold else FontWeight.Normal,
            fontSize = if (isHeader) 11.sp else 12.sp,
            fontFamily = if (!isHeader) FontFamily.Monospace else FontFamily.Default
        ),
        textAlign = TextAlign.Center,
        modifier = Modifier.width(width.dp)
    )
}
