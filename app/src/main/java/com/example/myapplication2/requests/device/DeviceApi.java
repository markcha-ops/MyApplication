package com.example.myapplication2.requests.device;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface DeviceApi {
//    @FormUrlEncoded
    @GET("devices")
    Call<List<Device>> devices();
}
