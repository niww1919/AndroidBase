package com.example.andoidbasecourse;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Switch aSwitch;
    public String TAG = "StartActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//        getDelegate().setLocalNightMode(R.style.AppDarkTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        (TextView)findViewById(R.id.editText).setTextDirection(WetherSettings.getCityName().);

//        aSwitch = findViewById(R.id.switch1);


    }

    public void setDarkMode(View view) {
        if (aSwitch.isChecked()) {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {

            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
//        MainActivity.this.setTheme(R.style.AppDarkTheme);
//        MainActivity.this.recreate();

    }

    public void intentListOfCountry(View view) {
        Intent intent = new Intent(this,ListOfCountryWithoutVisa.class);
//        startActivities(intent);
        startActivity(intent);

    }

    public void intentSettingsOfApp(View view) {
        Intent intent = new Intent(this, SettingsOfApp.class);
//        startActivities(intent);
        startActivity(intent);

    }


    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();

    }
}
