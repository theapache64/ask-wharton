package com.theah64.qpool.ui.activities.qpool.fragments

import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.theah64.qpool.models.questions.*


class QuestionViewModel : ViewModel() {

    var isFirstQuestion: Boolean = false
    var isLastQuestion: Boolean = false

    private val buttonClicks = MutableLiveData<Int>()
    var answer: String = ""

    var option1 = false
    var option2 = false
    var option3 = false
    var option4 = false

    fun getButtonClicks(): LiveData<Int> {
        return buttonClicks
    }

    var question: Question? = null
        set(value) {


            when (value) {

                is FactualQuestion -> factualQuestion = value
                is RadioQuestion -> radioQuestion = value
                is CheckBoxQuestion -> checkBoxQuestion = value
                is TimeQuestion -> timeQuestion = value
                else -> throw IllegalArgumentException("Undefined question type")
            }

            field = value
        }

    var factualQuestion: FactualQuestion? = null
    var radioQuestion: RadioQuestion? = null
    var checkBoxQuestion: CheckBoxQuestion? = null
    var timeQuestion: TimeQuestion? = null

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