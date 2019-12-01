package com.example.andoidbasecourse;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.andoidbasecourse.json.WeatherModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private static final int SETTING_CODE = 88;
    public static final int REQUEST_CODE = 7;
    Switch aSwitch;
    public String TAG = "StartActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);


        List<Weather> weatherOFWeekDays = new ArrayList<>();
        weatherOFWeekDays.add(new Weather("+10", "Monday", "1"));
        weatherOFWeekDays.add(new Weather("+5", "Tuesday", "2"));
        weatherOFWeekDays.add(new Weather("+3", "Wednesday", "3"));
        weatherOFWeekDays.add(new Weather("+6", "Thursday", "4"));
        weatherOFWeekDays.add(new Weather("+1", "Friday", "5"));
        weatherOFWeekDays.add(new Weather("-1", "Saturday", "6"));
        weatherOFWeekDays.add(new Weather("0", "Sunday", "7"));

        List<WeatherModel> weatherOfCity = new ArrayList<>();
//        weatherOfCity.add(new Weather("+23", "London", new Date(System.currentTimeMillis())));
//        weatherOfCity.add(new Weather("+5", "Moscow", new Date(System.currentTimeMillis())));
//        weatherOfCity.add(new Weather("+9", "London", new Date(System.currentTimeMillis())));


        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        WeatherAdapter adapter = new WeatherAdapter(this, weatherOFWeekDays);
        recyclerView.setAdapter(adapter);


        WeatherOfCityAdapter adapter2 = new WeatherOfCityAdapter(this, weatherOfCity);
        RecyclerView rv = findViewById(R.id.listOfCities);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter2);


    }

    public void intentSettingsOfApp(View view) {
        Intent intent = new Intent(MainActivity.this, SettingsOfApp.class);
        startActivityForResult(intent, SETTING_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SETTING_CODE) {
            recreate();
        }


        if (requestCode != REQUEST_CODE) {
            return;
        }
        ((TextView) findViewById(R.id.currentCityName)).setText(data.getStringExtra("City"));


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
        Button button = findViewById(R.id.activityButtonOfSettings);


        //noinspection SimplifiableIfStatement
        if (id == R.id.itemButtonOfSettings) {
            button.setVisibility(View.VISIBLE);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

}
