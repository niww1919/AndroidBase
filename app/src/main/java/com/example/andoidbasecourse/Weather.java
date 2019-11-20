package com.example.andoidbasecourse;

public class Weather {
    String temperatureOfDay;
    String dayOfWeek;
    String dayOfMonth;

    public Weather(String temperatureOfDay, String dayOfWeek, String dayOfMonth) {
        this.temperatureOfDay = temperatureOfDay;
        this.dayOfWeek = dayOfWeek;
        this.dayOfMonth = dayOfMonth;
    }

    public String getTemperatureOfDay() {
        return temperatureOfDay;
    }

    public void setTemperatureOfDay(String temperatureOfDay) {
        this.temperatureOfDay = temperatureOfDay;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(String dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }
}
