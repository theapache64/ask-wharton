package com.theah64.qpool.questions

class CheckBoxQuestion(
    question: Int,
    option1: Int,
    option2: Int,
    option3: Int?,
    option4: Int?,
    imageUrl: String? = null
) :
    RadioQuestion(question, option1, option2, option3, option4, imageUrl)