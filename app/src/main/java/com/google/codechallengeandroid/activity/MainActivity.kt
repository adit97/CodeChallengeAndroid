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
import com.google.codechallengeandroid.util.toast
import com.google.codechallengeandroid.util.toastAndroid
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val androidList = mutableListOf<AndroidModel>()
    private val androidAdapter = AndroidAdapter(androidList, this::onItemClick)

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
        val androidName = listOf(
            "Petit Four",
            "Cupcake",
            "Donut",
            "Eclair",
            "Froyo",
            "Gingerbread",
            "Honeycomb",
            "Ice Cream Sandwich",
            "Jelly Bean",
            "KitKat",
            "Lollipop",
            "Marshmallow",
            "Nougat",
            "Oreo",
            "Pie"
        )

        val androidVersion = listOf(
            "1.1",
            "1.5",
            "1.6",
            "2.0 – 2.1",
            "2.2 – 2.2.3",
            "2.3 – 2.3.7",
            "3.0 – 3.2.6",
            "4.0 – 4.0.4",
            "4.1 – 4.3.1",
            "4.4 – 4.4.4",
            "5.0 – 5.1.1",
            "6.0 – 6.0.1",
            "7.0 – 7.1.2",
            "8.0 – 8.1",
            "9.0"
        )

        val androidApiLevel = listOf(
            "2",
            "3",
            "4",
            "5-7",
            "8",
            "9-10",
            "11-13",
            "14-15",
            "16-18",
            "19-20",
            "21-22",
            "23",
            "24-25",
            "26-27",
            "28"
        )

        (0..14).forEach {
            val androidModel = AndroidModel(androidName[it], androidVersion[it],  androidApiLevel[it])
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

        if (id == R.id.btnLogout) {
            BinarApp.sp.logout()
            startActivity(Intent(this, WelcomeActivity::class.java))
            this.toast("Berhasil Logout")
            finish()
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    private fun onItemClick(it: AndroidModel) {
        this.toastAndroid(it.androidName)
    }
}
