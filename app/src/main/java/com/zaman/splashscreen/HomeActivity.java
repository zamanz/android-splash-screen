package com.zaman.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.zaman.splashscreen.Adapter.UserAdapter;
import com.zaman.splashscreen.Model.User;
import com.zaman.splashscreen.Services.UserService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {

    ListView listView;
    Button load_products;
    List list = new ArrayList<User>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("Retrofit CRUD");

        listView = findViewById(R.id.listView);
        load_products = findViewById(R.id.load_products);
        load_products.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ProductsActivity.class);
                startActivity(intent);
            }
        });

        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(UserService.BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).build();

        UserService userService = retrofit.create(UserService.class);

        Call<List<User>> users = userService.getUsers();
        users.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()){
                    //Log.d("data", String.valueOf(response.body()));
                    list = response.body();
                    listView.setAdapter(new UserAdapter(getApplicationContext(),R.layout.data_layout,list));
                    Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });


    }
}