package com.example.andoidbasecourse;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 7;
    Switch aSwitch;
    public String TAG = "StartActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


//        onClickButton();


    }

//    private void onClickButton() {
//        findViewById(R.id.go_to_browser).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                String url = "";
//                Uri url = Uri.parse("https://github.com");
//                Intent openBrowser = new Intent(Intent.ACTION_VIEW, url);
//                startActivity(openBrowser);
//            }
//        });
//
//        findViewById(R.id.create_sms).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                String url = "";
//
//                Intent openSms = new Intent(Intent.ACTION_SENDTO);
//
//                openSms.setData(Uri.parse("smsto:"));
//                String smg = "sds";
//                openSms.putExtra("sms_body", smg);
//                startActivity(openSms);
//            }
//        });
//    }

    public void setDarkMode(View view) {
        if (aSwitch.isChecked()) {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {

            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
//        MainActivity.this.setTheme(R.style.AppDarkTheme);
//        MainActivity.this.recreate();

    }


    public void intentSettingsOfApp(View view) {
        Intent intent = new Intent(this, SettingsOfApp.class);
//        startActivities(intent);
        startActivity(intent);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != REQUEST_CODE) {
            return ;
        }
        ((TextView)findViewById(R.id.currentCityName)).setText(data.getStringExtra("City"));

    }

}
