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
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import at.htlkaindorf.gehoertrainingsapp.beans.ChordSettings;
import at.htlkaindorf.gehoertrainingsapp.beans.IntervalSettings;
import at.htlkaindorf.gehoertrainingsapp.beans.IntervalSettingsDialogCallback;

public class IntervalsActivity extends AppCompatActivity implements IntervalSettingsDialogCallback {

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
    private IntervalSettings intervalSettingsValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intervals);

        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        tf = Typeface.createFromAsset(getAssets(), "font/opensans_regular.ttf");

        Intent intent = getIntent();
        if(intent != null && intent.hasExtra("intervalSettings")) {
            intervalSettingsValues = (IntervalSettings) intent.getSerializableExtra("intervalSettings");
        }

        ibtPlayInterval = findViewById(R.id.ibtPlayInterval);
        btUnison = findViewById(R.id.btUnison);
        btMinor2nd = findViewById(R.id.btMinor2nd);
        btMajor2nd = findViewById(R.id.btMajor2nd);
        btMinor3rd = findViewById(R.id.btMinor3rd);
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

        enableDisableButtons(intervalSettingsValues);
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
                case R.id.btMinor3rd:
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
        intervalSettings = new IntervalSettingsDialog(this, intervalSettingsValues, this);
        intervalSettings.setContentView(R.layout.activity_interval_pop_up);
        intervalSettings.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        intervalSettings.getWindow().setDimAmount(0.8f);
        intervalSettings.setCanceledOnTouchOutside(true);
        intervalSettings.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                onIntervalSettingsReturned(intervalSettingsValues);
            }
        });
        intervalSettings.show();
    }

    @Override
    public void onIntervalSettingsReturned(IntervalSettings intervalSettingsValues) {
        if(intervalSettingsValues.allIntervalFalse()) {
            intervalSettingsValues.setMajor2nd(true);
            intervalSettingsValues.setMajor3rd(true);
            intervalSettingsValues.setPerfect4th(true);
            intervalSettingsValues.setPerfect5th(true);
        }
        if(intervalSettingsValues.allPlayModeFalse()) {
            intervalSettingsValues.setAscending(true);
        }

        enableDisableButtons(intervalSettingsValues);
        this.intervalSettingsValues = intervalSettingsValues;
    }

    private void enableDisableButtons(IntervalSettings intervalSettingsValues) {
        if(intervalSettingsValues.isUnison()) { btUnison.setEnabled(true);} else {btUnison.setEnabled(false);}
        if(intervalSettingsValues.isMinor2nd()) { btMinor2nd.setEnabled(true);} else {btMinor2nd.setEnabled(false);}
        if(intervalSettingsValues.isMajor2nd()) { btMajor2nd.setEnabled(true);} else {btMajor2nd.setEnabled(false);}
        if(intervalSettingsValues.isMinor3rd()) { btMinor3rd.setEnabled(true);} else {btMinor3rd.setEnabled(false);}
        if(intervalSettingsValues.isMajor3rd()) { btMajor3rd.setEnabled(true);} else {btMajor3rd.setEnabled(false);}
        if(intervalSettingsValues.isPerfect4th()) { btPerfect4th.setEnabled(true);} else {btPerfect4th.setEnabled(false);}
        if(intervalSettingsValues.isTriton()) { btTritone.setEnabled(true);} else {btTritone.setEnabled(false);}
        if(intervalSettingsValues.isPerfect5th()) { btPerfect5th.setEnabled(true);} else {btPerfect5th.setEnabled(false);}
        if(intervalSettingsValues.isMinor6th()) { btMinor6th.setEnabled(true);} else {btMinor6th.setEnabled(false);}
        if(intervalSettingsValues.isMajor6th()) { btMajor6th.setEnabled(true);} else {btMajor6th.setEnabled(false);}
        if(intervalSettingsValues.isMinor7th()) { btMinor7th.setEnabled(true);} else {btMinor7th.setEnabled(false);}
        if(intervalSettingsValues.isMajor7th()) { btMajor7th.setEnabled(true);} else {btMajor7th.setEnabled(false);}
        if(intervalSettingsValues.isOctave()) { btOctave.setEnabled(true);} else {btOctave.setEnabled(false);}
    }
}