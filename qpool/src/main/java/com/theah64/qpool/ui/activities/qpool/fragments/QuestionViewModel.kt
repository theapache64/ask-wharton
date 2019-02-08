package com.theah64.qpool.ui.activities.qpool.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.theah64.qpool.R
import com.theah64.qpool.questions.Question

class QuestionViewModel : ViewModel() {

    private val buttonClicks = MutableLiveData<Int>()

    fun getButtonClicks(): LiveData<Int> {
        return buttonClicks
    }

    lateinit var question: Question

    fun onPrevButtonClicked() {
        buttonClicks.value = R.id.b_prev
    }

    fun onNextButtonClicked() {
        buttonClicks.value = R.id.b_next
    }
}