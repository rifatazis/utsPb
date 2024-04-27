package com.example.utsrifat.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.utsrifat.R;
import com.example.utsrifat.data.response.Users;
import com.example.utsrifat.data.retrofit.ApiConfig;
import com.example.utsrifat.data.retrofit.ApiService;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {
    public ProgressBar progressBar;
    public TextView tvNama, tvUsername, tvBio;
    public ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        progressBar = findViewById(R.id.progressBar);
        tvNama = findViewById(R.id.tvNama);
        tvUsername = findViewById(R.id.tvUsername);
        tvBio = findViewById(R.id.tvBio);
        image = findViewById(R.id.image);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String username = extras.getString("username");
            ApiService apiService = ApiConfig.getApiService();
            Call<Users> userCall = apiService.getUser(username);

            progressBar.setVisibility(View.VISIBLE);
            userCall.enqueue(new Callback<Users>() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onResponse(@NonNull Call<Users> call, @NonNull Response<Users> response) {
                    if (response.isSuccessful()){
                        progressBar.setVisibility(View.GONE);
                        Users user = response.body();
                        if (user != null){
                            tvNama.setText("Name: " + user.getName());
                            tvUsername.setText( "Username: " + user.getUsername());
                            tvBio.setText("Bio: " + user.getBio());
                            Picasso.get().load(user.getAvatarUrl()).into(image);
                        } else {
                            Snackbar.make(findViewById(android.R.id.content), "Do not get user data" , Snackbar.LENGTH_SHORT).show();
                        }
                    }
                }
                @Override
                public void onFailure(@NonNull Call<Users> call, @NonNull Throwable e) {
                    Snackbar.make(findViewById(android.R.id.content), "Error: " + e.getMessage(), Snackbar.LENGTH_SHORT).show();
                }
            });
        }
    }

}