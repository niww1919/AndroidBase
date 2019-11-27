package com.example.andoidbasecourse;

import java.util.Date;

public class WeathersAndCitys {
//    https://api.openweathermap.org/data/2.5/weather?q=Moscow,RU&appid=YOU_API_NUMBER

    String temperatureOfDay;
    String dayOfWeek;
    String dayOfMonth;
    String cityName;
    Date timeInCity;

    public WeathersAndCitys(String temperatureOfDay, String cityName, Date timeInCity) {
        this.temperatureOfDay = temperatureOfDay;
        this.cityName = cityName;
        this.timeInCity = timeInCity;
    }

    //    ImageView imageViewOfDay;

    public WeathersAndCitys(String temperatureOfDay, String dayOfWeek, String dayOfMonth) {
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

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getTimeInCity() {
        return timeInCity.toString().substring(0,16);
    }

    public void setTimeInCity(Date timeInCity) {
        this.timeInCity = timeInCity;
    }
}
