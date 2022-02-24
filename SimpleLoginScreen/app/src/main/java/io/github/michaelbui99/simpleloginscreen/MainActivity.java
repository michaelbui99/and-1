package io.github.michaelbui99.simpleloginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String LOGIN_EMAIL = "test@test.test";
    private final String LOGIN_PASSWORD = "test123123";
    private Context context;

    private EditText emailInput;
    private EditText passwordInput;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        emailInput = findViewById(R.id.input_email);
        passwordInput = findViewById(R.id.input_password);

        Button loginButton = findViewById(R.id.button_login);

        loginButton.setOnClickListener(this::onLogin);

    }


    public void onLogin(View v) {
        if (!credentialsAreCorrect()) {
            Toast.makeText(context, R.string.message_login_failed, Toast.LENGTH_SHORT).show();
            clearInputFields();
            return;
        }

        Toast.makeText(context, R.string.message_login_success, Toast.LENGTH_LONG).show();
        clearInputFields();
    }


    public boolean credentialsAreCorrect() {
        return emailInput.getText().toString().toLowerCase().equals(LOGIN_EMAIL.toLowerCase()) &&
                passwordInput.getText().toString().toLowerCase().equals(LOGIN_PASSWORD.toLowerCase());
    }

    public void clearInputFields(){
        emailInput.setText("");
        passwordInput.setText("");
    }
}