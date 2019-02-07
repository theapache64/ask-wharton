package com.theah64.qpool

import androidx.annotation.StringRes

open class RadioQuestion(
    question: Int,

    @StringRes val option1: Int,
    @StringRes val option2: Int,
    @StringRes val option3: Int?,
    @StringRes val option4: Int?,

    imageUrl: String? = null
) : FactualQuestion(question, imageUrl) {
}