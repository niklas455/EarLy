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
        btUnison = findViewById(R.id.btUnison);
        btMinor2nd = findViewById(R.id.btMinor2nd);
        btMajor2nd = findViewById(R.id.btMajor2nd);
        btMinor3rd = findViewById(R.id.btMinor3nd);
        btMajor3rd = findViewById(R.id.btMajor3rd);
        btPerfect4th = findViewById(R.id.btPerfect4th);
        btTritone = findViewById(R.id.btTritone);
        btPerfect5th = findViewById(R.id.btPerfect5th);
        btMinor6th = findViewById(R.id.btMinor6th);
        btMajor6th = findViewById(R.id.btMajor6th);
        btMinor7th = findViewById(R.id.btMinor7th);
        btMajor7th = findViewById(R.id.btMajor7th);
        btOctave = findViewById(R.id.btOctave);

        ibtPlayInterval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btUnison.setTypeface(tf);
        btMinor2nd.setTypeface(tf);
        btMajor2nd.setTypeface(tf);
        btMinor3rd.setTypeface(tf);
        btMajor3rd.setTypeface(tf);
        btPerfect4th.setTypeface(tf);
        btTritone.setTypeface(tf);
        btPerfect5th.setTypeface(tf);
        btMinor6th.setTypeface(tf);
        btMajor6th.setTypeface(tf);
        btMinor7th.setTypeface(tf);
        btMajor7th.setTypeface(tf);
        btOctave.setTypeface(tf);

        btUnison.setOnClickListener(onClickInterval);
        btMinor2nd.setOnClickListener(onClickInterval);
        btMajor2nd.setOnClickListener(onClickInterval);
        btMinor3rd.setOnClickListener(onClickInterval);
        btMajor3rd.setOnClickListener(onClickInterval);
        btPerfect4th.setOnClickListener(onClickInterval);
        btTritone.setOnClickListener(onClickInterval);
        btPerfect5th.setOnClickListener(onClickInterval);
        btMinor6th.setOnClickListener(onClickInterval);
        btMajor6th.setOnClickListener(onClickInterval);
        btMinor7th.setOnClickListener(onClickInterval);
        btMajor7th.setOnClickListener(onClickInterval);
        btOctave.setOnClickListener(onClickInterval);

    }

    private View.OnClickListener onClickInterval = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btUnison:
                    System.out.println("Unison");
                    break;
                case R.id.btMinor2nd:
                    System.out.println("Minor 2nd");
                    break;
                case R.id.btMajor2nd:
                    System.out.println("Major 2nd");
                    break;
                case R.id.btMinor3nd:
                    System.out.println("Minor 3rd");
                    break;
                case R.id.btMajor3rd:
                    System.out.println("Major 3rd");
                    break;
                case R.id.btPerfect4th:
                    System.out.println("Perfect 4th");
                    break;
                case R.id.btTritone:
                    System.out.println("Tritone");
                    break;
                case R.id.btPerfect5th:
                    System.out.println("Perfect 5th");
                    break;
                case R.id.btMinor6th:
                    System.out.println("Minor 6th");
                    break;
                case R.id.btMajor6th:
                    System.out.println("Major 6th");
                    break;
                case R.id.btMinor7th:
                    System.out.println("Minor 7th");
                    break;
                case R.id.btMajor7th:
                    System.out.println("Major 7th");
                    break;
                case R.id.btOctave:
                    System.out.println("Octave");
                    break;
            }
        }
    };

    public void openIntervalSettings(View v) {
        intervalSettings.setContentView(R.layout.activity_interval_pop_up);
        intervalSettings.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        intervalSettings.show();
    }
}