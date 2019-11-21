package com.example.googlesignin;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepository {

    private static WeatherRepository instance;
    private MutableLiveData<Weather1> weather;

    private MutableLiveData<Temp> temp;

    private WeatherRepository() {
        weather = new MutableLiveData<>();

        temp = new MutableLiveData<>();
    }


    public static synchronized WeatherRepository getInstance() {
        if (instance == null) {
            instance = new WeatherRepository();
        }
        return instance;
    }

    public LiveData<Weather1> getWeather() {
        return weather;

    }
    public LiveData<Temp> getTemp() {
        return temp;
    }

    public void updateWeather(String cityName) {
        WeatherApi weatherApi = ServiceGenerator.getWeatherApi();
        Call<WeatherResponse> call = weatherApi.getCity(cityName);
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                Log.i("retrofit",response.message());
                if (response.code() == 200) {
                    weather.setValue(response.body().getWeather());
                    temp.setValue(response.body().getTemp());
                }
            }
            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(" + t.getMessage());
            }
        });
    }
}

