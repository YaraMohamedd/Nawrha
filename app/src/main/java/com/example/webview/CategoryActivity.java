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

public class CategoryActivity extends AppCompatActivity {
    WebView web_category;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_category);
        bottomNavigationView=findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.navigation_category);
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
                        startActivity(new Intent(getApplicationContext(),CategoryActivity.class));
                        return  true;
                    case R.id.navigation_product:
                        startActivity(new Intent(getApplicationContext(),ProductActivity.class));
                        return  true;

                }
                return false;
            }
        });
        web_category=findViewById(R.id.web_category);
        web_category.setWebViewClient(new WebViewClient());
        web_category.loadUrl("https://nawrha.com/shop/");
        WebSettings webSettings = web_category.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }
    @Override
    public void onBackPressed() {
        if(web_category.canGoBack()){
            web_category.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}