package com.theah64.askwharton.ui.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import com.theah64.askwharton.BuildConfig
import com.theah64.askwharton.R
import com.theah64.askwharton.ui.main.MainActivity
import com.theah64.qpool.ui.base.BaseAppCompatActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseAppCompatActivity() {


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        tv_version.text = "v${BuildConfig.VERSION_NAME}"

        // Animating
        val blinkAnimation = AlphaAnimation(0f, 1f)
        blinkAnimation.duration = 1000

        tv_version.startAnimation(blinkAnimation)

        Handler().postDelayed({
            startActivity(MainActivity.getStartIntent(this))
            finish()
        }, 2000)
    }
}
