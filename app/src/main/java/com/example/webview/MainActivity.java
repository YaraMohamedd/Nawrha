package com.example.webview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
WebView webView;
BottomNavigationView bottom_navigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        bottom_navigation=findViewById(R.id.navigation);
        setContentView(R.layout.activity_main);
        bottom_navigation=findViewById(R.id.navigation);
        bottom_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_category:
                        startActivity(new Intent(getApplicationContext(),CategoryActivity.class));
                        return  true;
                    case R.id.navigation_favourite:
                        startActivity(new Intent(getApplicationContext(),FavoriteActivity.class));
                        return  true;
                    case R.id.navigation_cart:
                        startActivity(new Intent(getApplicationContext(),CartActivity.class));
                        return  true;
                    case R.id.navigation_product:
                        startActivity(new Intent(getApplicationContext(),ProductActivity.class));
                        return  true;

                }
                return false;
            }
        });
        bottom_navigation.setSelectedItemId(R.id.navigation_home);
        webView=findViewById(R.id.web);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://nawrha.com");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}