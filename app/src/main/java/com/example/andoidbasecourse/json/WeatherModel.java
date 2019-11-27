package com.example.andoidbasecourse.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherModel {

//    @SerializedName("weather")
//    @Expose
//    private List<Weather> weather = null;
//    @SerializedName("main")
//    @Expose
//    private Main_ main;
    @SerializedName("wind")
    @Expose
    private Wind wind;
    @SerializedName("clouds")
    @Expose
    private Clouds clouds;


//    public Main_ getMain() {
//        return main;
//    }
//
//    public void setMain(Main_ main) {
//        this.main = main;
//    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }
}