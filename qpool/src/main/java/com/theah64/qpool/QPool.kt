package com.theah64.qpool

object QPool {
    private lateinit var questions: Array<out Question>

    fun init(vararg questions: Question) {
        this.questions = questions
    }
}