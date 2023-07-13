package at.htlkaindorf.gehoertrainingsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class ScaleTheoryActivity extends AppCompatActivity {

    private TextView tvTitleScale;
    private TextView tvMajor;
    private TextView tvNaturalMinor;
    private TextView tvHarmonicMinor;
    private TextView tvMelodicMinor;
    private TextView tvTitleModes;
    private TextView tvIonian;
    private TextView tvDorian;
    private TextView tvPhrygian;
    private TextView tvLydian;
    private TextView tvMixolydian;
    private TextView tvAeolian;
    private TextView tvLocrian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_theory);

        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Typeface tf1 = Typeface.createFromAsset(getAssets(), "font/opensans_regular.ttf");
        Typeface tf2 = Typeface.createFromAsset(getAssets(), "font/opensans_bold.ttf");


        tvTitleScale = findViewById(R.id.tvTitleScale);
        tvMajor = findViewById(R.id.tvMajor);
        tvNaturalMinor = findViewById(R.id.tvNaturalMinor);
        tvHarmonicMinor = findViewById(R.id.tvHarmonicMinor);
        tvMelodicMinor = findViewById(R.id.tvMelodicMinor);
        tvTitleModes = findViewById(R.id.tvTitleModes);
        tvIonian = findViewById(R.id.tvIonian);
        tvDorian = findViewById(R.id.tvDorian);
        tvPhrygian = findViewById(R.id.tvPhrygian);
        tvLydian = findViewById(R.id.tvLydian);
        tvMixolydian = findViewById(R.id.tvMixolydian);
        tvAeolian = findViewById(R.id.tvAeolian);
        tvLocrian = findViewById(R.id.tvLocrian);

        tvTitleScale.setTypeface(tf2);
        tvMajor.setTypeface(tf1);
        tvNaturalMinor.setTypeface(tf1);
        tvHarmonicMinor.setTypeface(tf1);
        tvMelodicMinor.setTypeface(tf1);
        tvTitleModes.setTypeface(tf2);
        tvIonian.setTypeface(tf1);
        tvDorian.setTypeface(tf1);
        tvPhrygian.setTypeface(tf1);
        tvLydian.setTypeface(tf1);
        tvMixolydian.setTypeface(tf1);
        tvAeolian.setTypeface(tf1);
        tvLocrian.setTypeface(tf1);
    }
}