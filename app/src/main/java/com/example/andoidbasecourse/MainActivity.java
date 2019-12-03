package com.example.andoidbasecourse;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends BaseActivity {

    private static final int SETTING_CODE = 88;
    public static final int REQUEST_CODE = 7;
    Switch aSwitch;
    public String TAG = "StartActivity";
    TextView tvTestOKHttp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        try {
//            getApiOkHttpClient();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        tvTestOKHttp = findViewById(R.id.tvTestOKHttp);
        OkHttpHandler okHttpHandler = new OkHttpHandler();
        okHttpHandler.execute("https://ya.ru");



//        testOkHttpClient("http://openweathermap.org/", tvTestOKHttp);


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

    private void testOkHttpClient(String url, TextView textView) {
        OkHttpClient client = new OkHttpClient();
//        String run(String url)  throw
        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            textView.setText(string);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


//    private void getApiOkHttpClient() throws IOException {
//        OkHttpClient client = new OkHttpClient();
//
//        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
//        RequestBody body = RequestBody.create(mediaType, "inboundDate=2019-09-10&cabinClass=business&children=0&infants=0&country=US&currency=RUB&locale=en-US&originPlace=SFO-sky&destinationPlace=LHR-sky&outboundDate=2019-09-01&adults=1");
//        DownloadManager.Request request = null;
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
//            request = new TextClassification.Request.Builder()
//                    .url("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/pricing/v1.0")
//                    .post(body)
//                    .addHeader("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
//                    .addHeader("x-rapidapi-key", "3e0b779392msh8c61556a7d29d67p13768fjsnf2b54a679739")
//                    .addHeader("content-type", "application/x-www-form-urlencoded")
//                    .build();
//        }
//
//        Response response = client.newCall(request).execute();
//    }

    public void intentSettingsOfApp(View view) {
        Intent intent = new Intent(this, WeatherSettingsActivity.class);
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

    public class OkHttpHandler extends AsyncTask {
        OkHttpClient client = new OkHttpClient();


        @Override
        protected Object doInBackground(Object[] objects) {

            Request.Builder builder = new Request.Builder();
            builder.url(String.valueOf(objects[0]));
            Request request = builder.build();

            try {
                Response response = client.newCall(request).execute();
                return response.body().string();
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            tvTestOKHttp.setText(String.valueOf(o));
        }

    }
}
