package com.zaman.splashscreen.Services;

import com.zaman.splashscreen.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserService {
    public String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @GET("users")
    Call<List<User>> getUsers();
}
