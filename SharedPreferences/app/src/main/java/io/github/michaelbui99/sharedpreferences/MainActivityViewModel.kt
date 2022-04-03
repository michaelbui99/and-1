package io.github.michaelbui99.sharedpreferences

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel

class MainActivityViewModel(app: Application): AndroidViewModel(app) {
    private val prefs: SharedPreferences = app.getSharedPreferences("TextPrefs", MODE_PRIVATE)

    fun setSavedText(value: String){
        prefs.edit().putString("text",value ).apply()
    }

    fun getSavedText(): String?{
        return prefs.getString("text", "")
    }
}