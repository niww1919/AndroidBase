package com.example.andoidbasecourse;

public class Weather {
    int temperatureOfDay;
    String dayOfWeek;
    int dayOfMonth;

    public Weather(int temperatureOfDay, String dayOfWeek, int dayOfMonth) {
        this.temperatureOfDay = temperatureOfDay;
        this.dayOfWeek = dayOfWeek;
        this.dayOfMonth = dayOfMonth;
    }

    public int getTemperatureOfDay() {
        return temperatureOfDay;
    }

    public void setTemperatureOfDay(int temperatureOfDay) {
        this.temperatureOfDay = temperatureOfDay;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }
}
