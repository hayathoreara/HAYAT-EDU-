package com.example.data.repository

import com.example.data.model.*

object SyllabusRepository {
    val allChapters: List<Chapter> by lazy {
        MathsData.chapters + PhysicsData.chapters + ChemistryData.chapters
    }

    val motivationalQuotes = listOf(
        "\"Success is the sum of small efforts, repeated day in and day out.\" — Robert Collier",
        "\"The beautiful thing about learning is that no one can take it away from you.\" — B.B. King",
        "\"Focus on understanding concepts, not memorizing solutions. Mastery follows clarity.\"",
        "\"Discipline is the bridge between goals and accomplishment.\" — Jim Rohn",
        "\"Every formula mastered today is an exam mark secured tomorrow.\"",
        "\"Believe you can and you're halfway there.\" — Theodore Roosevelt"
    )

    fun getChapters(subject: SubjectType): List<Chapter> {
        return allChapters.filter { it.subject == subject }
    }

    fun getChapter(id: String): Chapter? {
        return allChapters.find { it.id == id }
    }

    fun getAllMcqs(subject: SubjectType? = null): List<McqQuestion> {
        val list = allChapters.flatMap { it.mcqs }
        return if (subject != null) list.filter { it.subject == subject } else list
    }

    fun getAllFormulas(subject: SubjectType? = null): List<Pair<FormulaItem, Chapter>> {
        val list = allChapters.flatMap { chapter ->
            chapter.formulas.map { it to chapter }
        }
        return if (subject != null) list.filter { it.second.subject == subject } else list
    }

    fun searchAll(query: String): List<SearchResult> {
        if (query.isBlank()) return emptyList()
        val q = query.trim().lowercase()
        val results = mutableListOf<SearchResult>()

        for (ch in allChapters) {
            // Check chapter title and overview
            if (ch.title.lowercase().contains(q) || ch.overview.lowercase().contains(q)) {
                results.add(
                    SearchResult(
                        title = ch.title,
                        subtitle = "Chapter ${ch.number} • ${ch.subject.title}",
                        type = "Chapter",
                        subject = ch.subject,
                        chapterId = ch.id,
                        contentSnippet = ch.overview.take(120) + "..."
                    )
                )
            }

            // Check formulas
            for (f in ch.formulas) {
                if (f.title.lowercase().contains(q) || f.formula.lowercase().contains(q) || f.explanation.lowercase().contains(q)) {
                    results.add(
                        SearchResult(
                            title = f.title,
                            subtitle = "${ch.title} • Formula",
                            type = "Formula",
                            subject = ch.subject,
                            chapterId = ch.id,
                            contentSnippet = "${f.formula} (${f.explanation})"
                        )
                    )
                }
            }

            // Check definitions
            for (def in ch.definitions) {
                if (def.first.lowercase().contains(q) || def.second.lowercase().contains(q)) {
                    results.add(
                        SearchResult(
                            title = def.first,
                            subtitle = "${ch.title} • Definition",
                            type = "Definition",
                            subject = ch.subject,
                            chapterId = ch.id,
                            contentSnippet = def.second
                        )
                    )
                }
            }

            // Check key points
            for (kp in ch.keyPoints) {
                if (kp.lowercase().contains(q)) {
                    results.add(
                        SearchResult(
                            title = "Key Point: ${ch.title}",
                            subtitle = "${ch.subject.title} • Chapter Note",
                            type = "Note",
                            subject = ch.subject,
                            chapterId = ch.id,
                            contentSnippet = kp
                        )
                    )
                }
            }

            // Check questions
            for (mcq in ch.mcqs) {
                if (mcq.question.lowercase().contains(q) || mcq.explanation.lowercase().contains(q)) {
                    results.add(
                        SearchResult(
                            title = mcq.question,
                            subtitle = "${ch.title} • MCQ",
                            type = "Question",
                            subject = ch.subject,
                            chapterId = ch.id,
                            contentSnippet = "Correct answer: ${mcq.options.getOrNull(mcq.correctOptionIndex) ?: ""}"
                        )
                    )
                }
            }
        }

        return results.take(30)
    }
}
