package com.example.andoidbasecourse;

public class WetherSettings {
    String cityName = "Moscow";
    boolean show1;
    boolean show2;

    private static WetherSettings instance;

    public static WetherSettings getInstance() {

        instance = (instance == null )? new WetherSettings() : instance;
        return instance;
    }

    public String getCityName() {
        return cityName;
    }

    public boolean isShow1() {
        return show1;
    }

    public boolean isShow2() {
        return show2;
    }
}
