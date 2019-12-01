package com.example.andoidbasecourse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.widget.SwitchCompat;

public class AppSettingsActivity extends BaseActivity {
    public static final int RESULT_OK = 1;
    TextView textView;
    ListView listView;
    LinearLayout linearLayout;
    SwitchCompat aSwitchSetDarkTheme;
    String city;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_settings);

        aSwitchSetDarkTheme = findViewById(R.id.switch1);
        aSwitchSetDarkTheme.setChecked(isDarkTheme());
        aSwitchSetDarkTheme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setDarkTheme(isChecked);
                recreate();
            }
        });



        clickOnBackButton();
        clickOnRadioButtons();


    }

    private void clickOnRadioButtons() {
        findViewById(R.id.radioButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

    public void returnResult() {

        RadioButton radioButton = findViewById(R.id.radioButton2);
        Intent intentResult = new Intent();
        intentResult.putExtra("City", radioButton.getText().toString());
        setResult(RESULT_OK, intentResult);

        finish();

    }

}
