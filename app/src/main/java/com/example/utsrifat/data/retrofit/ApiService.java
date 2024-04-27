package com.example.utsrifat.data.retrofit;

import com.example.utsrifat.data.response.SearchUsers;
import com.example.utsrifat.data.response.Users;

import retrofit2.Call;
import retrofit2.http.*;

public interface ApiService {

    @GET("search/users")
    Call<SearchUsers> searchUsers(@Query("q") String query);

    @GET("users/{username}")
    Call<Users> getUser(@Path("username") String username);

}
