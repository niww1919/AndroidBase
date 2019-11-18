package com.example.andoidbasecourse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

public class SettingsOfApp extends AppCompatActivity {
    public static final int RESULT_OK = 1;
    TextView textView;
    ListView listView;
    LinearLayout linearLayout;
    Switch aSwitch;
    String city;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_of_app);
        aSwitch = findViewById(R.id.switch1);

        clickOnBackButton();
        clickOnRadioButtons();


    }

    private void clickOnRadioButtons() {
        findViewById(R.id.radioButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                EditText editText = (EditText) findViewById(R.id.editText3);
                RadioButton radioButton = findViewById(R.id.radioButton2);
                Intent intentResult = new Intent();
                intentResult.putExtra("City", radioButton.getText().toString());
                setResult(RESULT_OK, intentResult);
//                finish();
            }
        });
    }

    private void clickOnBackButton() {
        findViewById(R.id.buttonBackOfSettings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                returnResult();

            }
        });
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

    public void returnResult() {

        RadioButton radioButton = findViewById(R.id.radioButton2);
        Intent intentResult = new Intent();
        intentResult.putExtra("City", radioButton.getText().toString());
        setResult(RESULT_OK, intentResult);

        finish();

    }


}
