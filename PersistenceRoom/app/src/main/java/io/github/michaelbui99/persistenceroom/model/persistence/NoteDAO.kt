package io.github.michaelbui99.persistenceroom.model.persistence

import androidx.lifecycle.LiveData
import androidx.room.*
import io.github.michaelbui99.persistenceroom.model.Note

@Dao
interface NoteDAO {
    @Insert
    fun addNote(note: Note)

    @Update
    fun updateNote(note: Note)

    @Delete
    fun deleteNote(note: Note)

    @Query("DELETE FROM note_table")
    fun deleteAllNotes()

    @Query("DELETE FROM note_table WHERE id=:noteId")
    fun deleteNoteById(noteId: Int)

    @Query("SELECT * FROM note_table ORDER BY createDate DESC")
    fun getAllNotes(): LiveData<List<Note>>
}

