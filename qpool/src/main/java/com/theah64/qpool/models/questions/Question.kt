package com.theah64.qpool.models.questions

import androidx.annotation.StringRes
import java.io.Serializable

open class Question(
    val question: String,
    val imageUrl: String? = null
) : Serializable {
    companion object {
        const val KEY = "question"
    }
}