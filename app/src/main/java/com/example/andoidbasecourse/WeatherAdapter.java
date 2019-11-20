package com.example.andoidbasecourse;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Weather> weather;
//    private ViewHolder viewHolder;

    public WeatherAdapter(Context context, List<Weather> weather) {
        this.inflater = LayoutInflater.from(context);
        this.weather = weather;
    }

    @NonNull
    @Override
    public WeatherAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {

        View view = inflater.inflate(R.layout.weather_of_week_day, viewGroup, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull WeatherAdapter.ViewHolder viewHolder, int position) {//todo why viewholder type??
        Weather currentWeather = this.weather.get(position);
//        viewHolder.dayOfWeek.setText(weather.getDayOfWeek());
//        viewHolder.temperatureOfDay.setText(weather.getTemperatureOfDay());
//        viewHolder.temperatureOfDay.setText("1");
        viewHolder.temperatureOfDay.setText(currentWeather.getDayOfWeek());




    }

    @Override
    public int getItemCount() {
        return weather.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView dayOfWeek;
        private TextView temperatureOfDay;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dayOfWeek = itemView.findViewById(R.id.dayOfWeek);
            temperatureOfDay = itemView.findViewById(R.id.temperatureOfDay);
        }

        public TextView getDayOfWeek() {
            return dayOfWeek;
        }

        public TextView getTemperatureOfDay() {
            return temperatureOfDay;
        }
    }
}
