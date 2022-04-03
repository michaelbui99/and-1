package io.github.michaelbui99.persistenceroom.model.persistence

import android.app.Application
import android.os.Build
import android.os.Looper
import androidx.annotation.RequiresApi
import androidx.core.os.HandlerCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.michaelbui99.persistenceroom.model.Note
import java.time.LocalDate
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class NoteRepository private constructor(app: Application) {

    private val database: NoteDatabase = NoteDatabase.getInstance(app)
    private val noteDAO: NoteDAO = database.noteDao()
    private var allNotes: LiveData<List<Note>> = MutableLiveData()
    private val executorService: ExecutorService = Executors.newFixedThreadPool(2)
    private val mainThreadHAndler = HandlerCompat.createAsync(Looper.getMainLooper())


    fun getAllNotes(): LiveData<List<Note>> {
        allNotes = noteDAO.getAllNotes()
        return allNotes
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun insertNote(note: Note): Unit {
        executorService.execute() {
            noteDAO.addNote(note)
        }
    }

    fun deleteAllNotes() {
        executorService.execute {
            noteDAO.deleteAllNotes()
        }
    }

    companion object {
        private var instance: NoteRepository? = null


        @Synchronized
        fun getInstance(app: Application): NoteRepository {
            if (instance == null) {
                instance = NoteRepository(app)
            }

            return instance as NoteRepository
        }
    }

}