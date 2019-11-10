package com.example.andoidbasecourse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

public class SettingsOfApp extends AppCompatActivity {
    TextView textView;
    ListView listView;
    LinearLayout linearLayout;
    Switch aSwitch;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_of_app);
//        aSwitch = findViewById(R.id.switch1);

    }
    public void setDarkModeInSettings(View view) {

//            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        if (aSwitch.isChecked()) {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {

            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
//        MainActivity.this.setTheme(R.style.AppDarkTheme);
//        MainActivity.this.recreate();

    }

}
