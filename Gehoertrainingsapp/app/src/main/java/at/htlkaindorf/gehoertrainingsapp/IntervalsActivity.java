package at.htlkaindorf.gehoertrainingsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class IntervalsActivity extends AppCompatActivity {

    private ImageButton ibtPlayInterval;
    private Button btUnison;
    private Button btMinor2nd;
    private Button btMajor2nd;
    private Button btMinor3rd;
    private Button btMajor3rd;
    private Button btPerfect4th;
    private Button btTritone;
    private Button btPerfect5th;
    private Button btMinor6th;
    private Button btMajor6th;
    private Button btMinor7th;
    private Button btMajor7th;
    private Button btOctave;
    private Dialog intervalSettings;

    private Typeface tf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intervals);
        intervalSettings = new Dialog(this);

        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        tf = Typeface.createFromAsset(getAssets(), "font/opensans_regular.ttf");

        ibtPlayInterval = findViewById(R.id.ibtPlayInterval);
        ibtPlayInterval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btUnison = findViewById(R.id.btUnison);
        btUnison.setTypeface(tf);
        btUnison.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btMinor2nd = findViewById(R.id.btMinor2nd);
        btMinor2nd.setTypeface(tf);
        btMinor2nd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btMajor2nd = findViewById(R.id.btMajor2nd);
        btMajor2nd.setTypeface(tf);
        btMajor2nd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btMinor3rd = findViewById(R.id.btMinor3nd);
        btMinor3rd.setTypeface(tf);
        btMinor3rd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btMajor3rd = findViewById(R.id.btMajor3rd);
        btMajor3rd.setTypeface(tf);
        btMajor3rd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btPerfect4th = findViewById(R.id.btPerfect4th);
        btPerfect4th.setTypeface(tf);
        btPerfect4th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btTritone = findViewById(R.id.btTritone);
        btTritone.setTypeface(tf);
        btTritone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btPerfect5th = findViewById(R.id.btPerfect5th);
        btPerfect5th.setTypeface(tf);
        btPerfect5th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btMinor6th = findViewById(R.id.btMinor6th);
        btMinor6th.setTypeface(tf);
        btMinor6th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btMajor6th = findViewById(R.id.btMajor6th);
        btMajor6th.setTypeface(tf);
        btMajor6th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btMinor7th = findViewById(R.id.btMinor7th);
        btMinor7th.setTypeface(tf);
        btMinor7th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btMajor7th = findViewById(R.id.btMajor7th);
        btMajor7th.setTypeface(tf);
        btMajor7th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btOctave = findViewById(R.id.btOctave);
        btOctave.setTypeface(tf);
        btOctave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void openIntervalSettings(View v) {
        intervalSettings.setContentView(R.layout.activity_interval_pop_up);
        intervalSettings.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        intervalSettings.show();
    }
}