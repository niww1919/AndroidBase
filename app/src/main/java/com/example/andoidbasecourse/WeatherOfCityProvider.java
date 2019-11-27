package com.example.andoidbasecourse;

import android.util.Log;

import com.example.andoidbasecourse.json.WeatherModel;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;

public class WeatherOfCityProvider  {

    public static final String TAG = "WEATHER";
    public static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?q=Moscow,RU&appid=";
    public static final String WEATHER_API_KEY = "e83d0265c9865659af525e50e89b8edd";


    private WeatherModel getWeatherModel() {

        try {
            final URL uri = new URL(WEATHER_URL + WEATHER_API_KEY);
            new Thread(new Runnable() {
                public void run() {
                    HttpURLConnection urlConnection = null;
                    try {
                        urlConnection = (HttpURLConnection) uri.openConnection();
                        urlConnection.setRequestMethod("GET"); // установка метода получения данных -GET
                        urlConnection.setReadTimeout(10000); // установка таймаута - 10 000 миллисекунд
                        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream())); // читаем  данные в поток
//                        String result = getLines(in);
                        String result = null;
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                            result = in.lines().collect(Collectors.joining("\n"));
                        }

                        Gson gson = new Gson();
                        final WeatherModel weatherModel = gson.fromJson(result, WeatherModel.class);
                    } catch (Exception e) {
                        Log.e(TAG, "Fail connection", e);
                        e.printStackTrace();
                    } finally {
                        if (null != urlConnection) {
                            urlConnection.disconnect();
                        }
                    }
                }
            }).start();
        } catch (MalformedURLException e) {
            Log.e(TAG, "Fail URI", e);
            e.printStackTrace();
        }
        return getWeatherModel(); //todo what to return
    }






}
