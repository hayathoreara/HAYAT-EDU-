package com.example.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

// Primary Branding (HAYAT EDU)
val PrimaryBlue = Color(0xFF2563EB)
val PrimaryBlueDark = Color(0xFF1D4ED8)
val PrimaryLight = Color(0xFF60A5FA)
val PrimaryContainerLight = Color(0xFFEFF6FF)
val PrimaryContainerDark = Color(0xFF1E293B)

// Subject Accents
val MathsBlue = Color(0xFF2563EB)
val MathsBlueLight = Color(0xFFDBEAFE)
val PhysicsPurple = Color(0xFF7C3AED)
val PhysicsPurpleLight = Color(0xFFEDE9FE)
val ChemistryGreen = Color(0xFF059669)
val ChemistryGreenLight = Color(0xFFD1FAE5)

val AmberStreak = Color(0xFFF59E0B)
val AmberStreakLight = Color(0xFFFEF3C7)
val RoseHighlight = Color(0xFFE11D48)
val RoseHighlightLight = Color(0xFFFFE4E6)

// Dark Theme Palette
val DarkBackground = Color(0xFF0B0F19)
val DarkSurface = Color(0xFF111827)
val DarkSurfaceVariant = Color(0xFF1F2937)
val DarkCard = Color(0xFF1E293B)
val DarkBorder = Color(0xFF334155)
val DarkTextPrimary = Color(0xFFF9FAFB)
val DarkTextSecondary = Color(0xFF9CA3AF)

// Light Theme Palette
val LightBackground = Color(0xFFF8FAFC)
val LightSurface = Color(0xFFFFFFFF)
val LightSurfaceVariant = Color(0xFFF1F5F9)
val LightCard = Color(0xFFFFFFFF)
val LightBorder = Color(0xFFE2E8F0)
val LightTextPrimary = Color(0xFF0F172A)
val LightTextSecondary = Color(0xFF64748B)

// Beautiful Gradients
val PremiumHeaderGradient = Brush.horizontalGradient(
    colors = listOf(Color(0xFF1E3A8A), Color(0xFF3B82F6))
)

val MathsGradient = Brush.linearGradient(
    colors = listOf(Color(0xFF2563EB), Color(0xFF38BDF8))
)

val PhysicsGradient = Brush.linearGradient(
    colors = listOf(Color(0xFF6D28D9), Color(0xFF8B5CF6))
)

val ChemistryGradient = Brush.linearGradient(
    colors = listOf(Color(0xFF047857), Color(0xFF10B981))
)

val StreakGradient = Brush.linearGradient(
    colors = listOf(Color(0xFFD97706), Color(0xFFF59E0B))
)

val HeroCardGradient = Brush.linearGradient(
    colors = listOf(Color(0xFF0F172A), Color(0xFF1E3A8A), Color(0xFF2563EB))
)
