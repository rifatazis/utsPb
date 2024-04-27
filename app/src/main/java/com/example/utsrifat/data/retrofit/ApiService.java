package com.example.utsrifat.data.retrofit;

import com.example.utsrifat.data.response.SearchUsers;
import com.example.utsrifat.data.response.Users;

import retrofit2.Call;
import retrofit2.http.*;

public interface ApiService {
//    @Headers("Authorization: token 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")
    @GET("search/users")
    Call<SearchUsers> searchUsers(@Query("q") String query);


//    @Headers("Authorization: token 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")
    @GET("users/{username}")
    Call<Users> getUser(@Path("username") String username);

}
