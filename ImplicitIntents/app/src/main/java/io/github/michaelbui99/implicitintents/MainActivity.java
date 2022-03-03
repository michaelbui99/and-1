package io.github.michaelbui99.implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private final String EMAIL_CONTENT = "Join this cult";
    private final String EMAIL_SUBJECT = "Cult invitation";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendEmailButton = findViewById(R.id.button_send_mail);

        sendEmailButton.setOnClickListener(this::onSendEmail);
    }

    public void onSendEmail(View v){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"mom@home.dk"});
        intent.putExtra(Intent.EXTRA_SUBJECT, EMAIL_SUBJECT);
        intent.putExtra(Intent.EXTRA_TEXT, EMAIL_CONTENT);

        startActivity(intent);
    }
}