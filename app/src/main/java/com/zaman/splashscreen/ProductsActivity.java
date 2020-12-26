package com.zaman.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.zaman.splashscreen.Services.ProductServices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        setTitle("Products List Laravel Api");

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}