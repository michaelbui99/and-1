package io.github.michaelbui99.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private EditText urlInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button goButton = findViewById(R.id.button_go);
        webView = findViewById(R.id.web_view);
        urlInput = findViewById(R.id.input_url);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://google.com");
        goButton.setOnClickListener(this::onGo);
    }


    public void onGo(View v) {
        String url ="";
        if (!urlInput.getText().toString().contains("https://")){
            url = "https://" + urlInput.getText().toString();
        }else{
            url = urlInput.getText().toString();
        }
        webView.loadUrl(url);
        urlInput.setText(webView.getUrl());
    }
}