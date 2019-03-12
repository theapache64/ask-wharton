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

    /**
     * Questions to be asked
     */
    override fun getQuestions(): Array<out Question> {

        //TODO: Replace dummy questions with real questions
        return arrayOf(
            // Name
            FactualQuestion(
                question = getString(R.string.q_name),
                imageUrl = "https://raw.githubusercontent.com/theapache64/ask-wharton/master/extras/photos/1.jpg"
            ),

            // Age
            RadioQuestion(
                question = getString(R.string.q_age),
                option1 = getString(R.string.age_20),
                option2 = getString(R.string.age_23),
                option3 = getString(R.string.age_25),
                option4 = Question.OPTION_NONE_OF_THE_ABOVE,
                imageUrl = "https://raw.githubusercontent.com/theapache64/ask-wharton/master/extras/photos/2.jpg"
            ),

            // Hobby
            CheckBoxQuestion(
                question = getString(R.string.q_hobby),
                option1 = getString(R.string.hobby_gaming),
                option2 = getString(R.string.hobby_writing),
                option3 = getString(R.string.hobby_reading),
                option4 = Question.OPTION_NONE_OF_THE_ABOVE,
                imageUrl = "https://raw.githubusercontent.com/theapache64/ask-wharton/master/extras/photos/3.jpg"
            ),

            // Sleep time
            TimeQuestion(
                question = getString(R.string.What_time_do_you_sleep),
                imageUrl = "https://raw.githubusercontent.com/theapache64/ask-wharton/master/extras/photos/4.jpg"
            )
        )
    }

    override fun getWelcomeMessageWithTitle(): Pair<String, String>? {
        return Pair("Hi Jake", "Thank you for trying this app")
    }

    /**
     * When survery gets finished, this method will get invoked
     */
    override fun onSurveyFinished(answers: List<Answer>) {

        val mailIntent = Intent(Intent.ACTION_SEND)
        mailIntent.data = Uri.parse("mailto:")
        mailIntent.type = "message/rfc822"
        mailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("theapache64@gmail.com"))
        mailIntent.putExtra(Intent.EXTRA_SUBJECT, "JakeWharton Answered!")
        mailIntent.putExtra(Intent.EXTRA_TEXT, getMailBody(answers))
        startActivity(Intent.createChooser(mailIntent, "Choose email client"))
    }

    /**
     * Simple method to create mail body
     */
    private fun getMailBody(answers: List<Answer>): String? {
        val stringBuilder = StringBuilder()

        stringBuilder.append("Hi theapache64, \nI've finished your interview. \n\n")

        answers.forEach {
            val answer = if (it.answer.trim().isEmpty()) "-" else it.answer
            stringBuilder.append("Q. ${it.question.question}\nA. ${answer}\n\n")
        }

        return stringBuilder.toString()
    }

}
