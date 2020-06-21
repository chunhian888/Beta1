package com.example.beta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class CheckTNB extends AppCompatActivity {
    private WebView WVtnb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_t_n_b);

        WVtnb = (WebView) findViewById(R.id.WVtnb);
        WVtnb.setWebViewClient(new WebViewClient());
        WVtnb.loadUrl("https://myaccount.mytnb.com.my/Payment/QuickPay/");

        WebSettings webSettings = WVtnb.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

        @Override
        public void onBackPressed(){
            if(WVtnb.canGoBack()){
                WVtnb.goBack();
                return;
            }else {
                super.onBackPressed();
            }
        }
    }
