package com.theah64.qpool.questions

import androidx.annotation.StringRes

/**
 * Standard adjective or term which classifies "questions with a known, single, unambiguous, objective,
 * and correct answer
 */
open class FactualQuestion(@StringRes question: Int, imageUrl: String? = null) : Question(question, imageUrl)