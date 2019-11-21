package com.example.googlesignin;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class WeatherViewModel extends ViewModel {

    WeatherRepository repository;

    public WeatherViewModel(){
        repository = WeatherRepository.getInstance();
    }

    LiveData<Weather1> getWeather() {
        return repository.getWeather();
    }

    LiveData<Temp> getTemp() {
        return repository.getTemp();
    }

    public void updateWeather(String s) {
        repository.updateWeather(s);
    }
}
