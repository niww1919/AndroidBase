package com.example.andoidbasecourse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.andoidbasecourse.json.WeatherModel;

import java.util.List;

public class WeatherOfCityAdapter extends RecyclerView.Adapter<WeatherOfCityAdapter.ViewHolder> {

    public static final String TAG = "WEATHER";
    public static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?q=Moscow,RU&appid=";
    public static final String WEATHER_API_KEY = "e83d0265c9865659af525e50e89b8edd";

    private LayoutInflater inflater;
    private List<WeatherModel> weather;
//    private ViewHolder viewHolder;

        public WeatherOfCityAdapter(Context context, List<WeatherModel> weather) {
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
        WeatherModel currentWeather = this.weather.get(position);


        viewHolder.clouds.setText((CharSequence) currentWeather.getClouds());
        viewHolder.wind.setText((CharSequence) currentWeather.getWind());
//        viewHolder.timeInCityName.setText(currentWeather.getTimeInCity());
//        viewHolder.imageViewOfDay.setImageURI(Uri.parse(String.valueOf(R.drawable.ic_beach_access_black_24dp)));


    }

    @Override
    public int getItemCount() {
        return weather.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView clouds;
        TextView timeInCityName;
        TextView wind;

        public ViewHolder(View itemView) {
            super(itemView);
            wind = itemView.findViewById(R.id.temperatureOfDay);
            clouds = itemView.findViewById(R.id.cityName);
            timeInCityName = itemView.findViewById(R.id.timeInCityName);
        }

        public TextView getClouds() {
            return clouds;
        }

        public TextView getWind() {
            return wind;
        }

    }
}
