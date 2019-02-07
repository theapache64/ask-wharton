package com.theah64.qpool.ui.activities.qpool

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.theah64.qpool.R
import com.theah64.qpool.questions.Question
import com.theah64.qpool.ui.activities.qpool.adapters.QuestionPagerAdapter
import io.github.inflationx.viewpump.ViewPumpContextWrapper

abstract class QPoolActivity : AppCompatActivity() {

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase!!))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<com.theah64.qpool.databinding.ActivityQpoolBinding>(
                this,
                R.layout.activity_qpool
            )

        binding.vpQuestions.adapter = QuestionPagerAdapter(getQuestions(), supportFragmentManager)
    }


    abstract fun getQuestions(): Array<out Question>
}