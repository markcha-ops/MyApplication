package com.example.myapplication2.requests.login;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginApi {

    // @FormUrlEncoded
    @POST("auth/login")
    Call<Token> login(
             @Body LoginModel loginModel
    );
}
