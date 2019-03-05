package com.google.codechallengeandroid.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.codechallengeandroid.R
import com.google.codechallengeandroid.adapter.AndroidAdapter
import com.google.codechallengeandroid.model.AndroidModel
import com.google.codechallengeandroid.util.BinarApp
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val androidList = mutableListOf<AndroidModel>()
    private val androidAdapter = AndroidAdapter(androidList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        setToolbar()
        getAndroidModel()
        setView()
    }

    private fun setView() = run {
        rvAndroid.run {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = androidAdapter
        }
        androidAdapter.notifyDataSetChanged()
    }

    private fun getAndroidModel() {
        (1..20).forEach {
            val androidModel = AndroidModel("siswa $it", "siswa$it@siswa.com", "api $it")
            androidList.add(androidModel)
        }
    }

    private fun setToolbar() {
        title = "Home"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.itemId

        if(id == R.id.btnLogout) {
            BinarApp.sp.logout()
            startActivity(Intent(this, WelcomeActivity::class.java))
            finish()
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
