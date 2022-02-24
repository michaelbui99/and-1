package io.github.michaelbui99.progressbarexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private final int PROGRESS_INCREMENT = 25;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button decreaseProgressButton = findViewById(R.id.button_decrease_progress);
        Button increaseProgressButton = findViewById(R.id.button_increase_progress);

        progressBar = findViewById(R.id.progress_bar);

        decreaseProgressButton.setOnClickListener(this::onDecreaseProgress);
        increaseProgressButton.setOnClickListener(this::onIncreaseProgress);

    }


    public void onIncreaseProgress(View view) {
        if (progressBar.getProgress() >= 100) {
            return;
        }
        progressBar.setProgress(progressBar.getProgress() + PROGRESS_INCREMENT);
    }

    public void onDecreaseProgress(View view) {

        if (progressBar.getProgress() <= 0) {
            return;
        }
        progressBar.setProgress(progressBar.getProgress() - PROGRESS_INCREMENT);
    }
}