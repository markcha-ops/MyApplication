package com.example.myapplication2.requests;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AuthenticationInterceptor implements Interceptor {

    private String authToken;
    private final String bearer = "Bearer ";

    public AuthenticationInterceptor(String token) {
        this.authToken = token;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        Request.Builder builder = original.newBuilder()
//                .header("Authorization", bearer + authToken);
                .header("Authorization", bearer + "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxOCIsInVzZXJuYW1lIjoiYWRtaW4iLCJhdXRoIjpbIlJPTEVfQURNSU4iXSwiZXhwIjoxNjc0Mzc3NjI0fQ.YNkTHnQ_f4O_uTpTTOwkHNYmO-qjMfkrRdhP9CuCM1ikbcWRTTT0cZErToWfNQLKPb-m2_x2bCwBbHW0akGDWQ");

        Request request = builder.build();
        return chain.proceed(request);
    }
}
