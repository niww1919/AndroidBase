package com.example.andoidbasecourse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setDarkMode(View view) {
//        super.setTheme(R.style.AppDarkTheme);
        super.setTheme(R.style.AppTheme);


    }
}
