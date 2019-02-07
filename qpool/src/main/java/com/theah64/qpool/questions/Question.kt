package com.theah64.qpool.questions

import androidx.annotation.StringRes
import java.io.Serializable

open class Question(
    @StringRes val question: Int,
    val imageUrl: String? = null
) : Serializable {
    companion object {
        const val KEY = "question"
    }
}