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
        btNaturalMinorScale = findViewById(R.id.btNaturalMinorScale);
        btHarmonicMinorScale = findViewById(R.id.btHarmonicMinorScale);
        btMelodicMinorScale = findViewById(R.id.btMelodicMinorScale);

        btMajorScale.setTypeface(tf);
        btNaturalMinorScale.setTypeface(tf);
        btHarmonicMinorScale.setTypeface(tf);
        btMelodicMinorScale.setTypeface(tf);

        btMajorScale.setOnClickListener(onClickScale);
        btNaturalMinorScale.setOnClickListener(onClickScale);
        btHarmonicMinorScale.setOnClickListener(onClickScale);
        btMelodicMinorScale.setOnClickListener(onClickScale);
    }

    private View.OnClickListener onClickScale = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btMajorScale:
                    System.out.println("Major Scale");
                    break;
                case R.id.btNaturalMinorScale:
                    System.out.println("Natural Minor Scale");
                    break;
                case R.id.btHarmonicMinorScale:
                    System.out.println("Harmonic Minor Scale");
                    break;
                case R.id.btMelodicMinorScale:
                    System.out.println("Melodic Minor Scale");
                    break;
            }
        }
    };

    public void openScaleSettings(View v) {
        scaleSettings.setContentView(R.layout.activity_scale_pop_up);
        scaleSettings.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        scaleSettings.show();
    }
}