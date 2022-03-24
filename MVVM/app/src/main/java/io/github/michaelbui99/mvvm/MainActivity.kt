package io.github.michaelbui99.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var noteInput: EditText
    private lateinit var addNoteButton: Button
    private lateinit var deleteAllButton: Button
    private lateinit var notes: TextView
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var loadingBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        noteInput = findViewById(R.id.input_note)
        addNoteButton = findViewById(R.id.button_addNote)
        deleteAllButton = findViewById(R.id.button_deleteAll)
        notes = findViewById(R.id.textView_notes)
        loadingBar = findViewById(R.id.loading_bar)

        viewModel.notes.observe(this){
            Log.i("main", "Callback")
            renderNotes()
        }

        addNoteButton.setOnClickListener() {
            viewModel.addNote(noteInput.text.toString())
            noteInput.setText("")
        }


        deleteAllButton.setOnClickListener(){
            viewModel.deleteAllNotes()
        }

    }

    private fun renderNotes() {
        notes.text = ""
        viewModel.notes.value?.forEach() {
            notes.append("\n$it")
        }
    }
}