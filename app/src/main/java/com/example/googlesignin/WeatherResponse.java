package com.example.googlesignin;

import java.util.List;

public class WeatherResponse {

    private List<Weather1> weather;
    private Temp main;
    public Weather1 getWeather(){
        return weather.get(0);
    }

    public Temp getTemp(){
        return main;
    }


}
