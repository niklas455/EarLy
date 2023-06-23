package at.htlkaindorf.gehoertrainingsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvAppName;
    private Button btIntervals;
    private Button btChords;
    private Button btScales;
    private Switch sbtDarkModeSwitch;

    Typeface tf1, tf2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        tf1 = Typeface.createFromAsset(getAssets(), "font/opensans_regular.ttf");
        tf2 = Typeface.createFromAsset(getAssets(), "font/opensans_bold.ttf");

        tvAppName = findViewById(R.id.tvAppName);
        tvAppName.setTypeface(tf2);

        // open Interval Activity
        btIntervals = (Button) findViewById(R.id.btIntervals);
        btIntervals.setTypeface(tf1);
        btIntervals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, IntervalsActivity.class);
                startActivity(intent);
            }
        });

        // open Chord Activity
        btChords = (Button) findViewById(R.id.btChords);
        btChords.setTypeface(tf1);
        btChords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChordsActivity.class);
                startActivity(intent);
            }
        });

        // open Scales Activity
        btScales = (Button) findViewById(R.id.btScales);
        btScales.setTypeface(tf1);
        btScales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ScalesActivity.class);
                startActivity(intent);
            }
        });

        sbtDarkModeSwitch = (Switch) findViewById(R.id.sbtDarkModeSwitch);
        sbtDarkModeSwitch.setChecked(true);
        sbtDarkModeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });
    }
}