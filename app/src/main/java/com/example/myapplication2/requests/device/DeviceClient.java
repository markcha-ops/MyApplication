package com.example.myapplication2.requests.device;

import com.example.myapplication2.requests.AuthenticationInterceptor;
import com.example.myapplication2.requests.login.Token;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DeviceClient {
//    private static final String BASE_URL = "http://192.168.0.213:8039/api/";
    private static final String BASE_URL = "http://59.26.54.80:8039/api/";
    private static Retrofit retrofit;
    public static DeviceApi getApiService(){return getInstance().create(DeviceApi.class);}
    private static Retrofit getInstance(){
        Gson gson = new GsonBuilder().setLenient().create();

        Token instance = Token.getInstance();
        AuthenticationInterceptor interceptor = new AuthenticationInterceptor(instance.getAccessToken());

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
    }
}
