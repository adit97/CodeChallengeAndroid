package com.google.codechallengeandroid.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.codechallengeandroid.R

class SplashScreenActivity : AppCompatActivity() {

    private var handler: Handler? = null
    private val delay: Long = 2000
    private val runnable: Runnable = Runnable {
        if(!isFinishing) {
            val intent = Intent(applicationContext, WelcomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        initView()
    }

    private fun initView() {
        openActivity()
    }

    private fun openActivity() {
        handler = Handler()
        handler!!.postDelayed(runnable, delay)
    }

    override fun onDestroy() {
        if(handler != null) {
            handler!!.removeCallbacks(runnable)
        }
        super.onDestroy()
    }
}
