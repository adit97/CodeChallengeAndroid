package com.google.codechallengeandroid.util

import android.content.Context
import android.widget.Toast

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.toastAndroid(message: String) {
    toast("Anda memilih android $message")
}