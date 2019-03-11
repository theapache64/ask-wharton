package com.theah64.qpool.models.questions

import androidx.annotation.StringRes
import com.theah64.qpool.ui.activities.qpool.fragments.QuestionFragment
import java.io.Serializable
import java.lang.IllegalArgumentException

open class Question(
    val question: String,
    val imageUrl: String? = null
) : Serializable {

    /**
     * checking if the none-of-the-above value set to option 4 if exits
     */
    fun checkNoneOfTheAboveConstraints(option1: String, option2: String, option3: String) {
        if (
            option1 == VALUE_NONE_OF_THE_ABOVE ||
            option2 == VALUE_NONE_OF_THE_ABOVE ||
            option3 == VALUE_NONE_OF_THE_ABOVE
        ) {
            throw IllegalArgumentException("$VALUE_NONE_OF_THE_ABOVE can only be set to option 4")
        }
    }

    companion object {
        const val KEY = "question"
        const val VALUE_NONE_OF_THE_ABOVE = "None of the above"
    }
}