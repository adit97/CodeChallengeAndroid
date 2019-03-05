package com.google.codechallengeandroid.data

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.google.codechallengeandroid.util.Constant

class PreferenceHelper(app: Application) {
    private val sp: SharedPreferences by lazy {
        app.getSharedPreferences("binar_app", Context.MODE_PRIVATE)
    }

    private val spe: SharedPreferences.Editor by lazy {
        sp.edit()
    }

    fun putString(key: String, value: String) {
        spe.putString(key, value).apply()
    }

    fun getString(key: String): String {
        return sp.getString(key, "") ?: ""
    }

    fun logout() {
        spe.clear().apply()
    }

    var fullName: String
        set(value) = spe.putString(Constant.FULL_NAME, value).apply()
        get() = sp.getString(Constant.FULL_NAME, "")?:""

    var emailAddress: String
        set(value) = spe.putString(Constant.EMAIL_ADDRESS, value).apply()
        get() = sp.getString(Constant.EMAIL_ADDRESS, "")?:""

    var universityOrOrganization: String
        set(value) = spe.putString(Constant.UNIVERSITY_OR_ORGANIZATION, value).apply()
        get() = sp.getString(Constant.UNIVERSITY_OR_ORGANIZATION, "")?:""

    var password: String
        set(value) = spe.putString(Constant.PASSWORD, value).apply()
        get() = sp.getString(Constant.PASSWORD, "")?:""

}