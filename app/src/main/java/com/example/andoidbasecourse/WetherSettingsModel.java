package com.example.andoidbasecourse;

public class WetherSettingsModel {

    String cityName = "London";
    boolean show1 = true;
    boolean show2 = false;

    private static WetherSettingsModel instance;

    public static WetherSettingsModel getInstance() {

        instance = (instance == null) ? new WetherSettingsModel() : instance;
        return instance;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public boolean isShow1() {
        return show1;
    }

    public void setShow1(boolean show1) {
        this.show1 = show1;
    }

    public boolean isShow2() {
        return show2;
    }

    public void setShow2(boolean show2) {
        this.show2 = show2;
    }
}
