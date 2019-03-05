package com.google.codechallengeandroid.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.codechallengeandroid.R
import com.google.codechallengeandroid.adapter.AndroidAdapter
import com.google.codechallengeandroid.model.AndroidModel
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

}
