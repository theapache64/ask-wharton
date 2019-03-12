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

            // Favorite Language
            RadioQuestion(
                question = getString(R.string.question_fav_lang),
                option1 = getString(R.string.lang_kotlin),
                option2 = getString(R.string.lang_java),
                option3 = getString(R.string.lang_python),
                option4 = getString(R.string.option_other),
                imageUrl = getImageUrl(1)
            ),

            // Favorite Project
            RadioQuestion(
                question = getString(R.string.question_fav_project),
                option1 = getString(R.string.project_retrofit),
                option2 = getString(R.string.project_rx_android),
                option3 = getString(R.string.project_butterknife),
                option4 = getString(R.string.option_other),
                imageUrl = getImageUrl(2)
            ),

            // Favorite Food
            FactualQuestion(
                question = getString(R.string.question_fav_food),
                imageUrl = getImageUrl(3)
            ),

            // Sleep time
            TimeQuestion(
                question = getString(R.string.question_sleep_time),
                imageUrl = getImageUrl(4)
            ),

            // Wake-up time
            TimeQuestion(
                question = getString(R.string.question_wake_up_time),
                imageUrl = getImageUrl(5)
            )
        )
    }

    /**
     * Returns valid image from github
     */
    private fun getImageUrl(id: Int): String? {
        require(id in 1..8) { "id should be between 1 and 8, but passed $id" }
        return "https://raw.githubusercontent.com/theapache64/ask-wharton/master/extras/photos/$id.jpg"
    }

    override fun getWelcomeMessageWithTitle(): Pair<String, String>? {
        return Pair(getString(R.string.welcome_title_hi_jake), getString(R.string.welcome_message))
    }

    /**
     * When survery gets finished, this method will get invoked
     */
    override fun onSurveyFinished(answers: List<Answer>) {

        val mailIntent = Intent(Intent.ACTION_SEND)
        mailIntent.data = Uri.parse("mailto:")
        mailIntent.type = "message/rfc822"
        mailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("theapache64@gmail.com"))
        mailIntent.putExtra(Intent.EXTRA_SUBJECT, "Jake Wharton Answered!")
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
