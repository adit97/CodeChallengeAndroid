package com.google.codechallengeandroid.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.codechallengeandroid.R
import com.google.codechallengeandroid.util.BinarApp
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initView()
    }

    private fun initView() {
        setToolbar()
        register()
    }

    private fun register() {
        btnRegisterUser.setOnClickListener {
            val fullName = etFullName.text.toString()
            val emailAddress = etEmailAddress.text.toString()
            val universityOrOrganization = etUniversityOrOrganization.text.toString()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()

            BinarApp.sp.fullName = fullName
            BinarApp.sp.emailAddress = emailAddress
            BinarApp.sp.universityOrOrganization =universityOrOrganization
            BinarApp.sp.password = password

            Toast.makeText(this, "Register berhasil", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun setToolbar() {
        val actionBar = supportActionBar
        actionBar!!.title = "Register"
        actionBar.setDisplayHomeAsUpEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
