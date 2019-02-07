package com.theah64.askwharton

import com.theah64.qpool.questions.*
import com.theah64.qpool.ui.activities.qpool.QPoolActivity

class MainActivity : QPoolActivity() {

    override fun getQuestions(): Array<out Question> {

        return arrayOf(
            // Name
            FactualQuestion(
                question = R.string.q_name
            ),

            // Age
            RadioQuestion(
                question = R.string.q_age,
                option1 = R.string.age_20,
                option2 = R.string.age_23,
                option3 = R.string.age_25,
                option4 = R.string.option_none_of_the_above
            ),

            // Hobby
            CheckBoxQuestion(
                question = R.string.q_hobby,
                option1 = R.string.hobby_gaming,
                option2 = R.string.hobby_writing,
                option3 = R.string.hobby_reading,
                option4 = R.string.option_none_of_the_above
            ),

            // Sleep time
            TimeQuestion(
                question = R.string.What_time_do_you_sleep
            )
        )
    }
}
