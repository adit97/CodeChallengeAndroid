package com.google.codechallengeandroid.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.codechallengeandroid.R
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        initView()
    }

    private fun initView() {
        openLogin()
        openRegister()
    }

    private fun openRegister() {
        btnRegister.setOnClickListener { startActivity(Intent(this, RegisterActivity::class.java)) }
    }

    private fun openLogin() {
        btnLogin.setOnClickListener { startActivity(Intent(this, LoginActivity::class.java)) }
    }
}
