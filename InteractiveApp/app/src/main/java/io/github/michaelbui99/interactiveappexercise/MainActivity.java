package io.github.michaelbui99.interactiveappexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private TextView displayText;
    private EditText inputText;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonToast = findViewById(R.id.button_toast);
        Button buttonSetText = findViewById(R.id.button_set_text);

        displayText = findViewById(R.id.display_text);
        inputText = findViewById(R.id.text_input);

        buttonToast.setOnClickListener(this::onButtonToast);
        buttonSetText.setOnClickListener(this::onSetText);

        // Called when activity is created
        Log.i(TAG, "onCreate was called");
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Called when activity is visible to user
        Log.i(TAG, "onStart called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Called when home screen is reached
        Log.i(TAG, "onDestroy called");
    }


    public void onButtonToast(View view) {
        Toast.makeText(this, R.string.toast_text, Toast.LENGTH_SHORT).show();
    }

    public void onSetText(View view){
        displayText.setText(inputText.getText());
        Log.i(TAG, displayText.getText().toString());
    }
}