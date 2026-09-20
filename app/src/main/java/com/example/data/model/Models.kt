package com.example.data.model

enum class SubjectType(val title: String, val shortName: String, val classLabel: String) {
    MATHEMATICS("Mathematics", "Maths", "Class 11 NCERT"),
    PHYSICS("Physics", "Physics", "Class 11 NCERT"),
    CHEMISTRY("Chemistry", "Chemistry", "Class 11 NCERT")
}

data class FormulaItem(
    val title: String,
    val formula: String,
    val explanation: String = "",
    val siUnit: String = "",
    val dimensions: String = ""
)

data class SolvedExample(
    val question: String,
    val solution: String,
    val keyStep: String = ""
)

data class McqQuestion(
    val id: String,
    val question: String,
    val options: List<String>,
    val correctOptionIndex: Int,
    val explanation: String,
    val chapterTitle: String = "",
    val subject: SubjectType = SubjectType.MATHEMATICS
)

data class PracticeQuestion(
    val question: String,
    val hint: String,
    val answer: String
)

data class Chapter(
    val id: String,
    val number: Int,
    val subject: SubjectType,
    val title: String,
    val overview: String,
    val keyPoints: List<String>,
    val formulas: List<FormulaItem>,
    val definitions: List<Pair<String, String>>,
    val examples: List<SolvedExample>,
    val practiceQuestions: List<PracticeQuestion>,
    val mcqs: List<McqQuestion>,
    val quickRevision: List<String>
)

data class BookmarkItem(
    val id: String,
    val type: BookmarkType,
    val title: String,
    val subject: SubjectType,
    val subtitle: String,
    val content: String,
    val chapterId: String = ""
)

enum class BookmarkType(val label: String) {
    CHAPTER("Chapter"),
    NOTE("Note"),
    FORMULA("Formula"),
    QUESTION("Question")
}

data class UserProfile(
    val name: String = "ABU HOREARA",
    val photoPath: String? = null,
    val streakDays: Int = 7,
    val totalStudyMinutes: Int = 540,
    val notificationsEnabled: Boolean = true,
    val studyGoalMinutes: Int = 90
)

data class SearchResult(
    val title: String,
    val subtitle: String,
    val type: String,
    val subject: SubjectType,
    val chapterId: String,
    val contentSnippet: String
)
