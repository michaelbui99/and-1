package io.github.michaelbui99.explicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    EditText messageInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView messageReceivedTextView = findViewById(R.id.message_received_textview);
        TextView message = findViewById(R.id.message_textview);
        Button sendButton = findViewById(R.id.button_send);
        messageInput = findViewById(R.id.input_message);

        sendButton.setOnClickListener(this::onSend);

        Intent intent = getIntent();
        boolean messageIsSent = intent.getExtras().getBoolean("messageIsSent");

        if (messageIsSent) {
            String receivedMessage = intent.getExtras().getString("message");

            messageReceivedTextView.setText(R.string.message_received_message);
            message.setText(receivedMessage);
        }
    }

    public void onSend(View v) {
        Intent intent = new Intent();
        intent.putExtra("reply", messageInput.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}