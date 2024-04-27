package com.example.utsrifat.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.utsrifat.R;
import com.example.utsrifat.data.response.SearchUsers;
import com.example.utsrifat.data.response.Users;
import com.example.utsrifat.data.retrofit.ApiConfig;
import com.example.utsrifat.data.retrofit.ApiService;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private UserAdapter adapter;
    private List<Users> usersList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);

        ApiService apiService = ApiConfig.getApiService();
        Call<SearchUsers> call = apiService.searchUsers("marc");

        call.enqueue(new Callback<SearchUsers>() {
            @Override
            public void onResponse(@NonNull Call<SearchUsers> call, @NonNull Response<SearchUsers> response) {
                if (response.isSuccessful() && response.body() != null) {
                    usersList.addAll(response.body().getUsers());
                    adapter = new UserAdapter(usersList);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                } else {
                    Snackbar.make(findViewById(android.R.id.content), "Do not get user data" , Snackbar.LENGTH_SHORT).show();                }
            }
            @Override
            public void onFailure(@NonNull Call<SearchUsers> call, @NonNull Throwable e) {
                Snackbar.make(findViewById(android.R.id.content), "Error: " + e.getMessage(), Snackbar.LENGTH_SHORT).show();
            }
        });
    }

}
