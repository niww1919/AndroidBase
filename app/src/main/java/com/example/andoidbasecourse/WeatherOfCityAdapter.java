package com.example.andoidbasecourse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Date;
import java.util.List;

public class WeatherOfCityAdapter extends RecyclerView.Adapter<WeatherOfCityAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Weather> weather;
//    private ViewHolder viewHolder;

    public WeatherOfCityAdapter(Context context, List<Weather> weather) {
        this.inflater = LayoutInflater.from(context);
        this.weather = weather;
    }


    @Override
    public WeatherOfCityAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {

        View view = inflater.inflate(R.layout.weather_in_city, viewGroup, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(WeatherOfCityAdapter.ViewHolder viewHolder, int position) {//todo why viewholder type??
        Weather currentWeather = this.weather.get(position);
        viewHolder.cityName.setText(currentWeather.getCityName());
        viewHolder.temperatureOfDay.setText(currentWeather.getTemperatureOfDay());
        viewHolder.timeInCityName.setText(currentWeather.getTimeInCity());
//        viewHolder.imageViewOfDay.setImageURI(Uri.parse(String.valueOf(R.drawable.ic_beach_access_black_24dp)));





    }

    @Override
    public int getItemCount() {
        return weather.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

         TextView cityName;
         TextView timeInCityName;
         TextView temperatureOfDay;

        public ViewHolder(  View itemView) {
            super(itemView);
            temperatureOfDay = itemView.findViewById(R.id.temperatureOfDay);
            cityName = itemView.findViewById(R.id.cityName);
            timeInCityName = itemView.findViewById(R.id.timeInCityName);
        }

        public TextView getCityName() {
            return cityName;
        }

        public TextView getTemperatureOfDay() {
            return temperatureOfDay;
        }

    }
}
