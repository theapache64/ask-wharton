package com.theah64.qpool.ui.activities.qpool

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.theah64.qpool.R
import com.theah64.qpool.databinding.ActivityQpoolBinding
import com.theah64.qpool.questions.Question
import com.theah64.qpool.ui.activities.qpool.adapters.QuestionPagerAdapter
import io.github.inflationx.viewpump.ViewPumpContextWrapper

abstract class QPoolActivity : AppCompatActivity(), Callback {

    private lateinit var binding: ActivityQpoolBinding
    private lateinit var adapter: QuestionPagerAdapter


    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase!!))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = DataBindingUtil.setContentView(this, R.layout.activity_qpool)

        // Attaching question adapter
        this.adapter = QuestionPagerAdapter(getQuestions(), supportFragmentManager)
        binding.vpQuestions.adapter = adapter
    }

    abstract fun getQuestions(): Array<out Question>

    override fun onNextButtonClicked() {
        val nextPos = binding.vpQuestions.currentItem + 1
        val totalPos = getQuestions().size
        if (nextPos < totalPos) {
            binding.vpQuestions.currentItem = nextPos
        } else {
            Log.d("X", "At the end, Submit")
        }
    }

    override fun onPrevButtonClicked() {
        val prevPos = binding.vpQuestions.currentItem - 1
        if (prevPos > -1) {
            binding.vpQuestions.currentItem = prevPos
        } else {
            Log.d("X", "At the start")
        }
    }


}

interface Callback {
    fun onNextButtonClicked()
    fun onPrevButtonClicked()
}


