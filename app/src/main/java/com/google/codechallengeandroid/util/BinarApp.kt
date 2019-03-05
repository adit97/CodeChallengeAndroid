package com.google.codechallengeandroid.util

import android.app.Application
import com.google.codechallengeandroid.data.PreferenceHelper

class BinarApp: Application() {
    companion object {
        lateinit var sp: PreferenceHelper
    }

    override fun onCreate() {
        super.onCreate()
        sp = PreferenceHelper(this)
    }
}