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

public class ScalesActivity extends AppCompatActivity {

    private ImageButton ibtPlayScale;
    private Button btMajorScale;
    private Button btNaturalMinorScale;
    private Button btHarmonicMinorScale;
    private Button btMelodicMinorScale;
    private Dialog scaleSettings;

    private Typeface tf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scales);
        scaleSettings = new Dialog(this);

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
    }

    public void openScaleSettings(View v) {
        scaleSettings.setContentView(R.layout.activity_scale_pop_up);
        scaleSettings.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        scaleSettings.show();
    }
}