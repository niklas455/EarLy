package at.htlkaindorf.gehoertrainingsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class ChordTheoryActivity extends AppCompatActivity {

    private TextView tvTitleChord;
    private TextView tvMajorTriad;
    private TextView tvMinorTriad;
    private TextView tvAugmentedTriad;
    private TextView tvDiminishedTriad;
    private TextView tvTitle7thChords;
    private TextView tvMajor7th;
    private TextView tvMinor7th;
    private TextView tvDominant7th;
    private TextView tvMinorMajor7th;
    private TextView tvHalfDim7th;
    private TextView tvDiminished7th;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chord_theory);

        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Typeface tf1 = Typeface.createFromAsset(getAssets(), "font/opensans_regular.ttf");
        Typeface tf2 = Typeface.createFromAsset(getAssets(), "font/opensans_bold.ttf");


        tvTitleChord = findViewById(R.id.tvTitleTriadChords);
        tvMajorTriad = findViewById(R.id.tvMajorTriad);
        tvMinorTriad = findViewById(R.id.tvMinorTriad);
        tvAugmentedTriad = findViewById(R.id.tvAugmentedTriad);
        tvTitle7thChords = findViewById(R.id.tvTitle7thChords);
        tvDiminishedTriad = findViewById(R.id.tvDiminishedTriad);
        tvMajor7th = findViewById(R.id.tvMajor7th);
        tvMinor7th = findViewById(R.id.tvMinor7th);
        tvDominant7th = findViewById(R.id.tvDominant7th);
        tvMinorMajor7th = findViewById(R.id.tvMinorMajor7th);
        tvHalfDim7th = findViewById(R.id.tvHalfDim7th);
        tvDiminished7th = findViewById(R.id.tvDiminished7th);

        tvTitleChord.setTypeface(tf2);
        tvMajorTriad.setTypeface(tf1);
        tvMinorTriad.setTypeface(tf1);
        tvAugmentedTriad.setTypeface(tf1);
        tvDiminishedTriad.setTypeface(tf1);
        tvTitle7thChords.setTypeface(tf2);
        tvMajor7th.setTypeface(tf1);
        tvMinor7th.setTypeface(tf1);
        tvDominant7th.setTypeface(tf1);
        tvMinorMajor7th.setTypeface(tf1);
        tvHalfDim7th.setTypeface(tf1);
        tvDiminished7th.setTypeface(tf1);
    }
}