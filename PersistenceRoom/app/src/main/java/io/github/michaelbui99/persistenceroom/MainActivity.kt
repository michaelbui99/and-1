package io.github.michaelbui99.persistenceroom

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import io.github.michaelbui99.persistenceroom.model.Note
import io.github.michaelbui99.persistenceroom.ui.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var titleInput: EditText
    private lateinit var addNoteButton: Button
    private lateinit var deleteAllButton: Button
    private lateinit var noteView: TextView
    private lateinit var viewModel: MainViewModel


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        titleInput = findViewById(R.id.input_title)
        addNoteButton = findViewById(R.id.button_addNote)
        deleteAllButton = findViewById(R.id.button_deleteAll)
        noteView = findViewById(R.id.textview_notes)

        viewModel.getAllNotes().observe(this) {
            renderNotes(it)
        }

        addNoteButton.setOnClickListener() {
            viewModel.addNote(titleInput.text.toString())
            titleInput.setText("")
        }

        deleteAllButton.setOnClickListener(){
            viewModel.deleteAllNotes()
        }
    }

    private fun renderNotes(notes: List<Note>) {
        noteView.text = ""
        notes.forEach {
            noteView.append("${it.title}\n")
        }
    }
}