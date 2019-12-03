package com.example.andoidbasecourse;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private static final int SETTING_CODE = 88;
    public static final int REQUEST_CODE = 7;
    public static final String CITY_NAME = "City Name";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.buttonStartWeatherSettings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startIntentSettingsOfWeather();
            }
        });


        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);

        NavigationView navigationView = findViewById(R.id.navigationView);
        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                toolbar,
                R.string.nav_app_bar_navigate_up_description,
                R.string.nav_app_bar_open_drawer_description);
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();


        List<Weather> weatherOFWeekDays = new ArrayList<>();
        weatherOFWeekDays.add(new Weather("+10", "Monday", "1"));
        weatherOFWeekDays.add(new Weather("+5", "Tuesday", "2"));
        weatherOFWeekDays.add(new Weather("+3", "Wednesday", "3"));
        weatherOFWeekDays.add(new Weather("+6", "Thursday", "4"));
        weatherOFWeekDays.add(new Weather("+1", "Friday", "5"));
        weatherOFWeekDays.add(new Weather("-1", "Saturday", "6"));
        weatherOFWeekDays.add(new Weather("0", "Sunday", "7"));


        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        WeatherAdapter adapter = new WeatherAdapter(this, weatherOFWeekDays);
        recyclerView.setAdapter(adapter);


    }

    @Override
    protected void onResume() {
        super.onResume();
//        ((ImageView)findViewById(R.id.imageViewOfDay)).setVisibility(WeatherSettingsModel.getInstance().isShowPicture());
//        findViewById(R.id.imageViewOfDay).setVisibility(View.INVISIBLE);//todo set image visible

//        ((TextView)findViewById(R.id.yourCurrentLocation)).setText(WeatherSettingsModel.getInstance().getYourLocation());
        //todo почему нужно делать каст чтобы установть текст

    }

    public void startIntentSettingsOfWeather() {

        startActivityForResult(new Intent(this, WeatherSettingsActivity.class), REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

//        if (requestCode != REQUEST_CODE || resultCode != RESULT_OK) return;
        ((TextView)findViewById(R.id.yourCurrentLocation)).setText(data.getStringExtra(CITY_NAME));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Button button = findViewById(R.id.buttonStartWeatherSettings);
        TextView textView = findViewById(R.id.dayOfWeek);
        ImageView imageView = findViewById(R.id.imageViewOfDay);


        //noinspection SimplifiableIfStatement
        if (id == R.id.itemButtonOfSettings) {
            if (item.isChecked()) {
                item.setChecked(false);
                button.setVisibility(View.INVISIBLE);
            } else {
                item.setChecked(true);
                button.setVisibility(View.VISIBLE);
            }
            return true;
        }

        if (id == R.id.action_off_day_of_week) {
            if (item.isChecked()) {
                textView.setVisibility(View.VISIBLE);
                item.setChecked(false);
            } else {
                textView.setVisibility(View.INVISIBLE);
                item.setChecked(true);
            }

            return true;
        }
        if (id == R.id.action_off_pic) {
            if (item.isChecked()) {
                imageView.setVisibility(View.VISIBLE);
                item.setChecked(false);
            } else {
                imageView.setVisibility(View.INVISIBLE);
                item.setChecked(true);
            }
        }


        return super.onOptionsItemSelected(item);
    }

}
