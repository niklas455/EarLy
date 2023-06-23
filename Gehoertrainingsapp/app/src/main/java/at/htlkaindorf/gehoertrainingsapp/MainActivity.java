package at.htlkaindorf.gehoertrainingsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btIntervals;
    private Button btChords;
    private Button btScales;
    private Switch sbtDarkModeSwitch;
    private Typeface tf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        tf = Typeface.createFromAsset(getAssets(), "fonts/OpenSans-Regular.ttf");

        // open Interval Activity
        btIntervals = (Button) findViewById(R.id.btIntervals);
        btIntervals.setTypeface(tf);
        btIntervals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, IntervalsActivity.class);
                startActivity(intent);
            }
        });

        // open Chord Activity
        btChords = (Button) findViewById(R.id.btChords);
        btChords.setTypeface(tf);
        btChords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChordsActivity.class);
                startActivity(intent);
            }
        });

        // open Scales Activity
        btScales = (Button) findViewById(R.id.btScales);
        btScales.setTypeface(tf);
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