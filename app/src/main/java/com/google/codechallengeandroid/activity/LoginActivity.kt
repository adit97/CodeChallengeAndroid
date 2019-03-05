package com.google.codechallengeandroid.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.codechallengeandroid.R
import com.google.codechallengeandroid.util.BinarApp
import com.google.codechallengeandroid.util.toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_welcome.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initView()
    }

    private fun initView() {
        setToolbar()
        clickLogin()
    }

    private fun clickLogin() {
        btnLoginUser.setOnClickListener {
            val emailAddress = etEmailAddressLogin.text.toString()
            val password = etPasswordLogin.text.toString()
            if(emailAddress != "" && password != "") {
                if(emailAddress == BinarApp.sp.emailAddress && password == BinarApp.sp.password){
                    BinarApp.sp.login = true
                    this.toast("Login berhasil")
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    this.toast("Email dan password anda salah")
                }
            }else{
                this.toast("Email dan Password tidak bolek kosong")
            }

        }
    }

    private fun setToolbar() {
        val actionBar = supportActionBar
        actionBar!!.title = "Login"
        actionBar.setDisplayHomeAsUpEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
