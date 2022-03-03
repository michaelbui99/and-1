package io.github.michaelbui99.explicitintents;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText messageInput;
    private ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView replyMessage = findViewById(R.id.reply_message);
        Button sendButton = findViewById(R.id.button_send);
        messageInput = findViewById(R.id.input_message);

        sendButton.setOnClickListener(this::onSend);

         activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    Intent intent = result.getData();

                    if (intent != null) {
                        String replyMessageText = intent.getExtras().getString("reply");
                        replyMessage.setText(replyMessageText);
                    }

                }
        );
    }

    public void onSend(View v) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("messageIsSent", true);
        intent.putExtra("message", messageInput.getText().toString());

        activityResultLauncher.launch(intent);
    }

}