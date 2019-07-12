package com.example.alc40phase1challenge_android;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class About_ALC extends AppCompatActivity {

    WebView webView;
    String URL = "https://andela.com/alc/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_alc);


        if (isNetworkAvailable())     //check if internet available or not
        {
            Toast.makeText(
                    this,
                    "Internet Connected",
                    Toast.LENGTH_LONG
            ).show();
            webView = findViewById(R.id.webview);
            webView.setWebViewClient(new WebViewClient() {   //it work's fine in an envirment but it's not the perfect sollution
                @Override
                public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                    handler.proceed();
                }
            });
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl(URL);
        } else    //Not connected
        {
            Toast.makeText(
                    this,
                    "Internet Disconnected",
                    Toast.LENGTH_LONG
            ).show();
        }
    }
        public boolean isNetworkAvailable()
        {
            final ConnectivityManager connectivityManager = ((ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE));
            return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
        }
}