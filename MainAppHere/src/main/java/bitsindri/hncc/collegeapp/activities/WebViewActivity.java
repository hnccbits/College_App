package bitsindri.hncc.collegeapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import bitsindri.hncc.collegeapp.R;


public class WebViewActivity extends AppCompatActivity {
    WebView webView;

    String placeholder_url="https://drive.google.com/file/d/0B4L4P11PTo2Bc3RhcnRlcl9maWxl/view?usp=sharing";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        Intent intent = getIntent();
        String pdf_url=intent.getStringExtra("url");
        if(!pdf_url.equals(null))
        {
            placeholder_url=pdf_url;
        }


        WebView webView = (WebView) findViewById(R.id.webview);



        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl(placeholder_url);

    }


}