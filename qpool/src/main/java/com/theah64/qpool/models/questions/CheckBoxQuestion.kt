package com.theah64.qpool.models.questions

class CheckBoxQuestion(
    question: String,
    option1: String,
    option2: String,
    option3: String?,
    option4: String?,
    imageUrl: String? = null
) :
    RadioQuestion(question, option1, option2, option3, option4, imageUrl)