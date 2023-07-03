package at.htlkaindorf.gehoertrainingsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import at.htlkaindorf.gehoertrainingsapp.beans.ChordSettings;
import at.htlkaindorf.gehoertrainingsapp.beans.ScaleSettings;
import at.htlkaindorf.gehoertrainingsapp.beans.ScaleSettingsDialogCallback;

public class ScalesActivity extends AppCompatActivity implements ScaleSettingsDialogCallback {

    private ImageButton ibtPlayScale;
    private Button btMajorScale;
    private Button btNaturalMinorScale;
    private Button btHarmonicMinorScale;
    private Button btMelodicMinorScale;
    private Dialog scaleSettings;

    private Typeface tf;
    private ScaleSettings scaleSettingsValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scales);

        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        tf = Typeface.createFromAsset(getAssets(), "font/opensans_regular.ttf");

        Intent intent = getIntent();
        if(intent != null && intent.hasExtra("scaleSettings")) {
            scaleSettingsValues = (ScaleSettings) intent.getSerializableExtra("scaleSettings");
        }

        ibtPlayScale = findViewById(R.id.ibtPlayScale);
        btMajorScale = findViewById(R.id.btMajorScale);
        btNaturalMinorScale = findViewById(R.id.btNaturalMinorScale);
        btHarmonicMinorScale = findViewById(R.id.btHarmonicMinorScale);
        btMelodicMinorScale = findViewById(R.id.btMelodicMinorScale);

        ibtPlayScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btMajorScale.setTypeface(tf);
        btNaturalMinorScale.setTypeface(tf);
        btHarmonicMinorScale.setTypeface(tf);
        btMelodicMinorScale.setTypeface(tf);

        btMajorScale.setOnClickListener(onClickScale);
        btNaturalMinorScale.setOnClickListener(onClickScale);
        btHarmonicMinorScale.setOnClickListener(onClickScale);
        btMelodicMinorScale.setOnClickListener(onClickScale);

        enableDisableButtons(scaleSettingsValues);
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
        scaleSettings = new ScaleSettingsDialog(this, scaleSettingsValues, this);
        scaleSettings.setContentView(R.layout.activity_scale_pop_up);
        scaleSettings.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        scaleSettings.getWindow().setDimAmount(0.8f);
        scaleSettings.setCanceledOnTouchOutside(true);
        scaleSettings.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                onScaleSettingsReturned(scaleSettingsValues);
            }
        });
        scaleSettings.show();
    }

    @Override
    public void onScaleSettingsReturned(ScaleSettings scaleSettingsValues) {
        if(scaleSettingsValues.allIntervalFalse()) {
            scaleSettingsValues.setMajor(true);
            scaleSettingsValues.setNaturalMinor(true);
        }
        if(scaleSettingsValues.allPlayModeFalse()) {
            scaleSettingsValues.setAscending(true);
        }

        enableDisableButtons(scaleSettingsValues);
        this.scaleSettingsValues = scaleSettingsValues;
    }

    private void enableDisableButtons(ScaleSettings scaleSettingsValues) {
        if(scaleSettingsValues.isMajor()) { btMajorScale.setEnabled(true);} else {btMajorScale.setEnabled(false);}
        if(scaleSettingsValues.isNaturalMinor()) { btNaturalMinorScale.setEnabled(true);} else {btNaturalMinorScale.setEnabled(false);}
        if(scaleSettingsValues.isHarmonicMinor()) { btHarmonicMinorScale.setEnabled(true);} else {btHarmonicMinorScale.setEnabled(false);}
        if(scaleSettingsValues.isMelodicMinor()) { btMelodicMinorScale.setEnabled(true);} else {btMelodicMinorScale.setEnabled(false);}
    }
}