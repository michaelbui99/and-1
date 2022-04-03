package io.github.michaelbui99.persistenceroom.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.michaelbui99.persistenceroom.model.Note
import io.github.michaelbui99.persistenceroom.model.persistence.NoteRepository

class MainViewModel(app: Application ): AndroidViewModel(app) {
    private val repository = NoteRepository.getInstance(app)

    fun getAllNotes(): LiveData<List<Note>> {
        return repository.getAllNotes()
    }

    fun addNote(title: String){
        val note = Note(title = title)
        repository.insertNote(note)
    }

    fun deleteAllNotes(){
        repository.deleteAllNotes()
    }
}