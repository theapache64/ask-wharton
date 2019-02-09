package com.theah64.qpool.models.questions

import androidx.annotation.StringRes

/**
 * Standard adjective or term which classifies "questions with a known, single, unambiguous, objective,
 * and correct answer
 */
open class FactualQuestion(question: String, imageUrl: String? = null) : Question(question, imageUrl)