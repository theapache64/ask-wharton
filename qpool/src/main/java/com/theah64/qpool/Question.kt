package com.theah64.qpool

import androidx.annotation.StringRes

open class Question(
    @StringRes val question: Int,
    val imageUrl: String? = null
)