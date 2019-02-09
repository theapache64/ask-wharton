package com.theah64.qpool.ui.activities.qpool.fragments

import android.util.Log
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
        Log.e("X", "Prev button clicked @vm")
        buttonClicks.value = ID_PREV
    }

    fun onNextButtonClicked() {
        Log.e("X", "Next button clicked @vm")
        buttonClicks.value = ID_NEXT
    }

    companion object {
        const val ID_PREV = 1
        const val ID_NEXT = 2
    }
}