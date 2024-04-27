package com.example.utsrifat.data.retrofit;

import com.example.utsrifat.data.response.SearchUsers;
import com.example.utsrifat.data.response.Users;

import retrofit2.Call;
import retrofit2.http.*;

public interface ApiService {
    @Headers("Authorization: token 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")
    @GET("search/users")
    Call<SearchUsers> searchUsers(@Query("q") String query);


    @Headers("Authorization: token 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")
    @GET("users/{username}")
    Call<Users> getUser(@Path("username") String username);

}
