package io.github.michaelbui99.persistenceroom.model.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.github.michaelbui99.persistenceroom.model.Note


@Database(entities = [Note::class], version = 2)
abstract class NoteDatabase : RoomDatabase() {

   abstract fun noteDao(): NoteDAO

    companion object {
        private var instance: NoteDatabase? = null

        @Synchronized
        fun getInstance(context: Context): NoteDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java, "note_database.db"
                ).fallbackToDestructiveMigration().build()
            }

            return instance as NoteDatabase
        }
    }
}