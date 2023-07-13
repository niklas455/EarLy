package at.htlkaindorf.gehoertrainingsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.lang.reflect.Type;

import at.htlkaindorf.gehoertrainingsapp.beans.ChordSettings;
import at.htlkaindorf.gehoertrainingsapp.beans.IntervalSettings;
import at.htlkaindorf.gehoertrainingsapp.beans.ScaleSettings;

public class MainActivity extends AppCompatActivity {

    private TextView tvAppName;
    private Button btIntervals;
    private Button btChords;
    private Button btScales;
    private Switch sbtDarkModeSwitch;

    private IntervalSettings intervalSettings;
    private ChordSettings chordSettings;
    private ScaleSettings scaleSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Typeface tf1 = Typeface.createFromAsset(getAssets(), "font/opensans_regular.ttf");
        Typeface tf2 = Typeface.createFromAsset(getAssets(), "font/opensans_bold.ttf");

        tvAppName = findViewById(R.id.tvAppName);
        tvAppName.setTypeface(tf2);

        intervalSettings = new IntervalSettings(false, false, true, false, true, true, false, true, false, false, false, false, false, true, false, false);
        chordSettings = new ChordSettings(true, true, false, false, false, false, false, false, false, false, false, false, true);
        scaleSettings = new ScaleSettings(true, true, false, false, false, false, false, false, false, true, false);

        // open Interval Activity
        btIntervals = (Button) findViewById(R.id.btIntervals);
        btIntervals.setTypeface(tf1);
        btIntervals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, IntervalsActivity.class);
                intent.putExtra("intervalSettings", intervalSettings);
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
                intent.putExtra("chordSettings", chordSettings);
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
                intent.putExtra("scaleSettings", scaleSettings);
                startActivity(intent);
            }
        });

        sbtDarkModeSwitch = (Switch) findViewById(R.id.sbtDarkModeSwitch);
        sbtDarkModeSwitch.setChecked(isSystemInDarkMode(this));
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

    public boolean isSystemInDarkMode(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService(Context.UI_MODE_SERVICE);
        return uiModeManager.getNightMode() == UiModeManager.MODE_NIGHT_YES;
    }
}