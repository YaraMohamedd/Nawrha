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

public class CartActivity extends AppCompatActivity {
WebView web_cart;
BottomNavigationView bottom_navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        bottom_navigation.setSelectedItemId(R.id.navigation_cart);
        bottom_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));

                        return  true;
                    case R.id.navigation_category:
                        startActivity(new Intent(getApplicationContext(),CategoryActivity.class));
                        return  true;
                    case R.id.navigation_favourite:
                        startActivity(new Intent(getApplicationContext(),FavoriteActivity.class));

                        return  true;
                    case R.id.navigation_product:
                        startActivity(new Intent(getApplicationContext(),ProductActivity.class));
                        return  true;
                }
                return false;
            }
        });
        web_cart=findViewById(R.id.web_cart);
        web_cart.setWebViewClient(new WebViewClient());
        web_cart.loadUrl("http://nawrha.com");
        WebSettings webSettings = web_cart.getSettings();
        webSettings.setJavaScriptEnabled(true);


    }
    @Override
    public void onBackPressed() {
        if(web_cart.canGoBack()){
            web_cart.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}