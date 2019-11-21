package com.example.googlesignin;

public class Weather1 {
    private String main;
    private double temp;
    public Weather1(String main, double temp) {
        this.main = main;
        this.temp = temp;
    }

    public String getMain() {
        return main;
    }

    public Temp getTemp() {
        return new Temp(temp);
    }

}

