package io.github.michaelbui99.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var textInput: EditText
    private lateinit var setTextButton: Button
    private lateinit var text: TextView
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textInput = findViewById(R.id.input_text)
        setTextButton = findViewById(R.id.button_setText)
        text = findViewById(R.id.textview)

        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        setTextButton.setOnClickListener{
            viewModel.setSavedText(textInput.text.toString())
            textInput.setText("")
            text.text = viewModel.getSavedText()
        }
    }

    override fun onStop() {
        super.onStop()
        viewModel.setSavedText(text.text.toString())
    }

    override fun onStart() {
        super.onStart()
        text.text = viewModel.getSavedText()
    }
}