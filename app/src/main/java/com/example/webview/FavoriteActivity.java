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

public class FavoriteActivity extends AppCompatActivity {
 WebView web_favourite;
 BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_favorite);
        bottomNavigationView=findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.navigation_favourite);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.navigation_home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        return  true;
                    case R.id.navigation_category:
                        startActivity(new Intent(getApplicationContext(),CategoryActivity.class));
                        return  true;
                    case R.id.navigation_cart:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        return  true;
                    case R.id.navigation_product:
                        startActivity(new Intent(getApplicationContext(),ProductActivity.class));
                        return  true;
                }
                return false;
            }
        });
        web_favourite=findViewById(R.id.web_favourite);
        web_favourite.setWebViewClient(new WebViewClient());
        web_favourite.loadUrl("https://nawrha.com/wishlist");
        WebSettings webSettings = web_favourite.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }
    @Override
    public void onBackPressed() {
        if(web_favourite.canGoBack()){
            web_favourite.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}