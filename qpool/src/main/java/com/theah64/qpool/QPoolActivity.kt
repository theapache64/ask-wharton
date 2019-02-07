package com.theah64.qpool

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract open class QPoolActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qpool)
    }


    abstract fun getQuestions(): Array<out Question>
}