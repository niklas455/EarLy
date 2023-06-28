package at.htlkaindorf.gehoertrainingsapp;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.annotation.NonNull;

import at.htlkaindorf.gehoertrainingsapp.beans.ChordSettings;
import at.htlkaindorf.gehoertrainingsapp.beans.ChordSettingsDialogCallback;
import at.htlkaindorf.gehoertrainingsapp.beans.IntervalSettings;
import at.htlkaindorf.gehoertrainingsapp.beans.IntervalSettingsDialogCallback;

public class IntervalSettingsDialog extends Dialog {

    private Switch sbtUnison;
    private Switch sbtMinor2nd;
    private Switch sbtMajor2nd;
    private Switch sbtMinor3rd;
    private Switch sbtMajor3rd;
    private Switch sbtPerfect4th;
    private Switch sbtTritone;
    private Switch sbtPerfect5th;
    private Switch sbtMinor6th;
    private Switch sbtMajor6th;
    private Switch sbtMinor7th;
    private Switch sbtMajor7th;
    private Switch sbtOctave;
    private CheckBox cbAscending;
    private CheckBox cbDescending;
    private CheckBox cbHarmonic;

    private IntervalSettings intervalSettingsValues;
    private IntervalSettingsDialogCallback callback;

    public IntervalSettingsDialog(@NonNull Context context, IntervalSettings intervalSettingsValues, IntervalSettingsDialogCallback callback) {
        super(context);
        this.intervalSettingsValues = intervalSettingsValues;
        this.callback = callback;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interval_pop_up);

        sbtUnison = findViewById(R.id.sbtUnison);
        sbtMinor2nd = findViewById(R.id.sbtMinor2nd);
        sbtMajor2nd = findViewById(R.id.sbtMajor2nd);
        sbtMinor3rd = findViewById(R.id.sbtMinor3rd);
        sbtMajor3rd = findViewById(R.id.sbtMajor3rd);
        sbtPerfect4th = findViewById(R.id.sbtPerfect4th);
        sbtTritone = findViewById(R.id.sbtTritone);
        sbtPerfect5th = findViewById(R.id.sbtPerfect5th);
        sbtMinor6th = findViewById(R.id.sbtMinor6th);
        sbtMajor6th = findViewById(R.id.sbtMajor6th);
        sbtMinor7th = findViewById(R.id.sbtMinor7th);
        sbtMajor7th = findViewById(R.id.sbtMajor7th);
        sbtOctave = findViewById(R.id.sbtOctave);
        cbAscending = findViewById(R.id.cbAscending);
        cbDescending = findViewById(R.id.cbDescending);
        cbHarmonic = findViewById(R.id.cbHarmonic);

        setIntervalSettings();

        sbtUnison.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                intervalSettingsValues.setUnison(sbtUnison.isChecked());
            }
        });

        sbtMinor2nd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                intervalSettingsValues.setMinor2nd(sbtMinor2nd.isChecked());
            }
        });

        sbtMajor2nd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                intervalSettingsValues.setMajor2nd(sbtMajor2nd.isChecked());
            }
        });

        sbtMinor3rd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                intervalSettingsValues.setMinor3rd(sbtMinor3rd.isChecked());
            }
        });

        sbtMajor3rd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                intervalSettingsValues.setMajor3rd(sbtMajor3rd.isChecked());
            }
        });

        sbtPerfect4th.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                intervalSettingsValues.setPerfect4th(sbtPerfect4th.isChecked());
            }
        });

        sbtTritone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                intervalSettingsValues.setTriton(sbtTritone.isChecked());
            }
        });

        sbtPerfect5th.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                intervalSettingsValues.setPerfect5th(sbtPerfect5th.isChecked());
            }
        });

        sbtMinor6th.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                intervalSettingsValues.setMinor6th(sbtMinor6th.isChecked());
            }
        });

        sbtMajor6th.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                intervalSettingsValues.setMajor6th(sbtMajor6th.isChecked());
            }
        });

        sbtMinor7th.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                intervalSettingsValues.setMinor7th(sbtMinor7th.isChecked());
            }
        });

        sbtMajor7th.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                intervalSettingsValues.setMajor7th(sbtMajor7th.isChecked());
            }
        });

        sbtOctave.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                intervalSettingsValues.setOctave(sbtOctave.isChecked());
            }
        });

        cbAscending.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                intervalSettingsValues.setAscending(cbAscending.isChecked());
            }
        });

        cbDescending.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                intervalSettingsValues.setDescending(cbDescending.isChecked());
            }
        });

        cbHarmonic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                intervalSettingsValues.setHarmonic(cbHarmonic.isChecked());
            }
        });

    }

    private void setIntervalSettings() {
        sbtUnison.setChecked(intervalSettingsValues.isUnison());
        sbtMinor2nd.setChecked(intervalSettingsValues.isMinor2nd());
        sbtMajor2nd.setChecked(intervalSettingsValues.isMajor2nd());
        sbtMinor3rd.setChecked(intervalSettingsValues.isMinor3rd());
        sbtMajor3rd.setChecked(intervalSettingsValues.isMajor3rd());
        sbtPerfect4th.setChecked(intervalSettingsValues.isPerfect4th());
        sbtTritone.setChecked(intervalSettingsValues.isTriton());
        sbtPerfect5th.setChecked(intervalSettingsValues.isPerfect5th());
        sbtMinor6th.setChecked(intervalSettingsValues.isMinor6th());
        sbtMajor6th.setChecked(intervalSettingsValues.isMajor6th());
        sbtMinor7th.setChecked(intervalSettingsValues.isMinor7th());
        sbtMajor7th.setChecked(intervalSettingsValues.isMajor7th());
        sbtOctave.setChecked(intervalSettingsValues.isOctave());
        cbAscending.setChecked(intervalSettingsValues.isAscending());
        cbDescending.setChecked(intervalSettingsValues.isDescending());
        cbHarmonic.setChecked(intervalSettingsValues.isHarmonic());
    }

    private void sendIntervalSettingsBack (IntervalSettings intervalSettingsValues) {
        if(callback != null) {
            callback.onIntervalSettingsReturned(intervalSettingsValues);
        }
    }
}
