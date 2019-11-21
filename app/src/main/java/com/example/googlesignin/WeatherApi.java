package com.example.googlesignin;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeatherApi {

    @GET("data/2.5/weather?&appid=efcc4e6d63a99de898c36b146dbf378e")
    Call<WeatherResponse> getCity(@Query("q") String city);
}
