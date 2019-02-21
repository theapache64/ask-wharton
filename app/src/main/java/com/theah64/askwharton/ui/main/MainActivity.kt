package com.theah64.askwharton.ui.main

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.theah64.askwharton.R
import com.theah64.qpool.models.Answer
import com.theah64.qpool.models.questions.*
import com.theah64.qpool.ui.activities.qpool.QPoolActivity

class MainActivity : QPoolActivity() {

    companion object {
        fun getStartIntent(context: Context): Intent {
            val intent = Intent(context, MainActivity::class.java)
            return intent
        }
    }

    override fun onSurveyFinished(answers: List<Answer>) {

        val mailIntent = Intent(Intent.ACTION_SEND)
        mailIntent.data = Uri.parse("mailto:")
        mailIntent.type = "text/plain"
        mailIntent.putExtra(Intent.EXTRA_EMAIL, "theapache64@gmail.com")
        mailIntent.putExtra(Intent.EXTRA_SUBJECT, "JakeWharton Answered!")
        mailIntent.putExtra(Intent.EXTRA_TEXT, getFormatted(answers))
        startActivity(Intent.createChooser(mailIntent, "Choose email client"))
    }

    private fun getFormatted(answers: List<Answer>): String? {
        val stringBuilder = StringBuilder()
        answers.forEach {
            stringBuilder.append("${it.question.question}\n${it.answer}\n\n")
        }
        return stringBuilder.toString()
    }


    override fun getQuestions(): Array<out Question> {

        //TODO: Replace dummy questions with real questions
        return arrayOf(
            // Name
            FactualQuestion(
                question = getString(R.string.q_name),
                imageUrl = "https://i.stack.imgur.com/7VcXZ.jpg"
            ),

            // Age
            RadioQuestion(
                question = getString(R.string.q_age),
                option1 = getString(R.string.age_20),
                option2 = getString(R.string.age_23),
                option3 = getString(R.string.age_25),
                option4 = getString(R.string.option_none_of_the_above)
            ),

            // Hobby
            CheckBoxQuestion(
                question = getString(R.string.q_hobby),
                option1 = getString(R.string.hobby_gaming),
                option2 = getString(R.string.hobby_writing),
                option3 = getString(R.string.hobby_reading),
                option4 = getString(R.string.option_none_of_the_above)
            ),

            // Sleep time
            TimeQuestion(
                question = getString(R.string.What_time_do_you_sleep)
            )
        )
    }
}
