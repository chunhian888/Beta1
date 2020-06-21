package com.example.beta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class EPay extends AppCompatActivity {
    private WebView WVEpay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_pay);
        WVEpay = (WebView) findViewById(R.id.WVEpay);
        WVEpay.setWebViewClient(new WebViewClient());
        //WVEpay.loadUrl("https://www.google.com");
        WVEpay.loadUrl("https://www.e-pay.com.my/shop/category/1/mobile-reload");

        WebSettings webSettings = WVEpay.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed(){
        if(WVEpay.canGoBack()){
            WVEpay.goBack();
            return;
        }else {
            super.onBackPressed();
        }
    }
}
