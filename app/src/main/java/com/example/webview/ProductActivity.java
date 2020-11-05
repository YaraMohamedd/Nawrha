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

public class ProductActivity extends AppCompatActivity {
WebView web_product;
BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_product);
        bottomNavigationView=findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.navigation_product);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        return  true;
                    case R.id.navigation_favourite:
                        startActivity(new Intent(getApplicationContext(),FavoriteActivity.class));
                        return  true;
                    case R.id.navigation_cart:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        return  true;
                    case R.id.navigation_category:
                        startActivity(new Intent(getApplicationContext(),CategoryActivity.class));
                        return  true;
                }
                return false;
            }
        });
        web_product=findViewById(R.id.web_product);
        web_product.setWebViewClient(new WebViewClient());
        web_product.loadUrl("https://nawrha.com/compare/");
        WebSettings webSettings = web_product.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
    @Override
    public void onBackPressed() {
        if(web_product.canGoBack()){
            web_product.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}