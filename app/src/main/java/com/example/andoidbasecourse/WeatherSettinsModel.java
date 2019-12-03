package com.example.andoidbasecourse;

/**
 * Realize  Singleton
 */
public class WeatherSettinsModel {
    String yourLocation = "London";
    boolean showPicture = true;

    private static WeatherSettinsModel instance;

    public static WeatherSettinsModel getInstance() {

        instance = instance == null ? new WeatherSettinsModel() : instance;
        return instance;

    }

    public String getYourLocation() {
        return yourLocation;
    }

    public void setYourLocation(String yourLocation) {
        this.yourLocation = yourLocation;
    }

    public boolean isShowPicture() {
        return showPicture;
    }

    public void setShowPicture(boolean showPicture) {
        this.showPicture = showPicture;
    }
}
