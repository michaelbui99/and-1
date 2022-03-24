package io.github.michaelbui99.mvvm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    var notes: MutableLiveData<MutableList<String>> = MutableLiveData()
    var isLoading: MutableLiveData<Boolean> = MutableLiveData(false)

    init {
        val emptyList = mutableListOf<String>()
        notes.value = emptyList
    }

    fun addNote(note: String) {
        val currentNotes = notes.value
        currentNotes?.add(note)
        notes.value = currentNotes
    }

    fun deleteAllNotes() {
        notes.value = mutableListOf()
    }

}