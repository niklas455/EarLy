package at.htlkaindorf.gehoertrainingsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class IntervalTheoryActivity extends AppCompatActivity {

    private TextView tvTitleInterval;
    private TextView tvUnison;
    private TextView tvMinor2nd;
    private TextView tvMajor2nd;
    private TextView tvMinor3rd;
    private TextView tvMajor3rd;
    private TextView tvPerfect4th;
    private TextView tvTritone;
    private TextView tvPerfect5th;
    private TextView tvMinor6th;
    private TextView tvMajor6th;
    private TextView tvMinor7th;
    private TextView tvMajor7th;
    private TextView tvOctave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interval_theory);

        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Typeface tf1 = Typeface.createFromAsset(getAssets(), "font/opensans_regular.ttf");
        Typeface tf2 = Typeface.createFromAsset(getAssets(), "font/opensans_bold.ttf");


        tvTitleInterval = findViewById(R.id.tvTitleInterval);
        tvUnison = findViewById(R.id.tvUnison);
        tvMinor2nd = findViewById(R.id.tvMinor2nd);
        tvMajor2nd = findViewById(R.id.tvMajor2nd);
        tvMinor3rd = findViewById(R.id.tvMinor3rd);
        tvMajor3rd = findViewById(R.id.tvMajor3rd);
        tvPerfect4th = findViewById(R.id.tvPerfect4th);
        tvTritone = findViewById(R.id.tvTritone);
        tvPerfect5th = findViewById(R.id.tvPerfect5th);
        tvMinor6th = findViewById(R.id.tvMinor6th);
        tvMajor6th = findViewById(R.id.tvMajor6th);
        tvMinor7th = findViewById(R.id.tvMinor7th);
        tvMajor7th = findViewById(R.id.tvMajor7th);
        tvOctave = findViewById(R.id.tvOctave);

        tvTitleInterval.setTypeface(tf2);
        tvUnison.setTypeface(tf1);
        tvMinor2nd.setTypeface(tf1);
        tvMajor2nd.setTypeface(tf1);
        tvMinor3rd.setTypeface(tf1);
        tvMajor3rd.setTypeface(tf1);
        tvPerfect4th.setTypeface(tf1);
        tvTritone.setTypeface(tf1);
        tvPerfect5th.setTypeface(tf1);
        tvMinor6th.setTypeface(tf1);
        tvMajor6th.setTypeface(tf1);
        tvMinor7th.setTypeface(tf1);
        tvMajor7th.setTypeface(tf1);
        tvOctave.setTypeface(tf1);
    }
}