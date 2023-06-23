package at.htlkaindorf.gehoertrainingsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ScalesActivity extends AppCompatActivity {

    private ImageButton ibtPlayScale;
    private Button btMajorScale;
    private Button btNaturalMinorScale;
    private Button btHarmonicMinorScale;
    private Button btMelodicMinorScale;
    private ImageButton ibtSettings;

    private Typeface tf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scales);

        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        tf = Typeface.createFromAsset(getAssets(), "font/opensans_regular.ttf");

        ibtPlayScale = findViewById(R.id.ibtPlayScale);
        ibtPlayScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btMajorScale = findViewById(R.id.btMajorScale);
        btMajorScale.setTypeface(tf);
        btMajorScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btNaturalMinorScale = findViewById(R.id.btNaturalMinorScale);
        btNaturalMinorScale.setTypeface(tf);
        btNaturalMinorScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btHarmonicMinorScale = findViewById(R.id.btHarmonicMinorScale);
        btHarmonicMinorScale.setTypeface(tf);
        btHarmonicMinorScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btMelodicMinorScale = findViewById(R.id.btMelodicMinorScale);
        btMelodicMinorScale.setTypeface(tf);
        btMelodicMinorScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ibtSettings = findViewById(R.id.ibtScaleSettings);
        ibtSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScalesActivity.this, ScalePopUpActivity.class);
                startActivity(intent);
            }
        });
    }
}