package com.example.myapplication2.requests.login;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginClient {
//    private static final String BASE_URL = "http://192.168.0.213:8039/api/";
    private static final String BASE_URL = "http://59.26.54.80:8039/api/";
    private static Retrofit retrofit;
    public static LoginApi getApiService(){return getInstance().create(LoginApi.class);}
    private static Retrofit getInstance(){
        Gson gson = new GsonBuilder().setLenient().create();
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}
