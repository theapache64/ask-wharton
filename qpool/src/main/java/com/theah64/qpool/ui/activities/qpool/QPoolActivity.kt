package com.theah64.qpool.ui.activities.qpool

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.theah64.qpool.R
import com.theah64.qpool.databinding.ActivityQpoolBinding
import com.theah64.qpool.models.Answer
import com.theah64.qpool.models.questions.Question
import com.theah64.qpool.ui.activities.qpool.adapters.QuestionPagerAdapter
import com.theah64.qpool.ui.base.BaseAppCompatActivity

abstract class QPoolActivity : BaseAppCompatActivity(), Callback {

    private lateinit var binding: ActivityQpoolBinding
    private lateinit var adapter: QuestionPagerAdapter
    private val answersMap = mutableMapOf<Int, Answer>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = DataBindingUtil.setContentView(this, R.layout.activity_qpool)

        // Attaching question adapter
        this.adapter = QuestionPagerAdapter(getQuestions(), supportFragmentManager)
        binding.vpQuestions.adapter = adapter
    }

    abstract fun getQuestions(): Array<out Question>
    abstract fun onSurveyFinished(answers: List<Answer>)

    override fun onNextButtonClicked(answer: Answer) {


        Log.e("X", "Next button clicked @act")

        val currentItem = binding.vpQuestions.currentItem

        // Saving answer
        answersMap[currentItem] = answer


        // Moving to next question
        val nextPos = currentItem + 1
        val totalPos = getQuestions().size
        if (nextPos < totalPos) {
            binding.vpQuestions.currentItem = nextPos
        } else {
            // Survey finished
            onSurveyFinished(answersMap.values.toList())
        }
    }

    override fun onPrevButtonClicked() {

        Log.e("X", "Prev button clicked @act")

        val prevPos = binding.vpQuestions.currentItem - 1
        if (prevPos > -1) {
            binding.vpQuestions.currentItem = prevPos
        } else {
            Log.d("X", "At the start")
        }
    }


}

interface Callback {
    fun onNextButtonClicked(answer: Answer)
    fun onPrevButtonClicked()
}


