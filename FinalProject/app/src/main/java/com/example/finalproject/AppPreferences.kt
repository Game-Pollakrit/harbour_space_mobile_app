package com.example.finalproject

import android.app.Activity
import android.content.Context

class AppPreferences(context: Activity) {

    private val KEY_OPTION = "What's you like"
    private val preferences = context.getSharedPreferences("final_app", Context.MODE_PRIVATE)

    fun setOption(value: String) {
        with(preferences.edit()) {
            putString(KEY_OPTION, value)
            apply()
        }
    }

    fun getOptions(): String? {
        return preferences.getString(KEY_OPTION, "Hi")
    }
}