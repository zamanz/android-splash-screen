package com.zaman.splashscreen.Services;

import com.zaman.splashscreen.Model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductServices {

    public String BASE_URL = "https://flyweight-inception.000webhostapp.com/api/v1/";

    @GET("products")
    Call<List<Product>> getProducts();
}
