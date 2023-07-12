package at.htlkaindorf.gehoertrainingsapp;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.annotation.NonNull;

import at.htlkaindorf.gehoertrainingsapp.beans.ScaleSettings;
import at.htlkaindorf.gehoertrainingsapp.beans.ScaleSettingsDialogCallback;

public class ScaleSettingsDialog extends Dialog {

    private Switch sbtMajorIonian;
    private Switch sbtNaturalMinorAeolian;
    private Switch sbtHarmonicMinor;
    private Switch sbtMelodicMinor;
    private Switch sbtDorian;
    private Switch sbtPhrygian;
    private Switch sbtLydian;
    private Switch sbtMixolydian;
    private Switch sbtLocrian;
    private CheckBox cbAscending;
    private CheckBox cbDescending;

    private ScaleSettings scaleSettingsValues;
    private ScaleSettingsDialogCallback callback;

    public ScaleSettingsDialog(@NonNull Context context, ScaleSettings scaleSettingsValues, ScaleSettingsDialogCallback callback) {
        super(context);
        this.scaleSettingsValues =scaleSettingsValues;
        this.callback = callback;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_pop_up);

        sbtMajorIonian = findViewById(R.id.sbtMajorIonian);
        sbtNaturalMinorAeolian = findViewById(R.id.sbtNaturalMinorAeolian);
        sbtHarmonicMinor = findViewById(R.id.sbtHarmonicMinor);
        sbtMelodicMinor = findViewById(R.id.sbtMelodicMinor);
        sbtDorian = findViewById(R.id.sbtDorian);
        sbtPhrygian = findViewById(R.id.sbtPhrygian);
        sbtLydian = findViewById(R.id.sbtLydian);
        sbtMixolydian = findViewById(R.id.sbtMixolydian);
        sbtLocrian = findViewById(R.id.sbtLocrian);
        cbAscending = findViewById(R.id.cbAscending);
        cbDescending = findViewById(R.id.cbDescending);

        setScaleSettings();

        sbtMajorIonian.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                scaleSettingsValues.setMajorIonian(sbtMajorIonian.isChecked());
            }
        });

        sbtNaturalMinorAeolian.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                scaleSettingsValues.setNaturalMinorAeolian(sbtNaturalMinorAeolian.isChecked());
            }
        });

        sbtHarmonicMinor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                scaleSettingsValues.setHarmonicMinor(sbtHarmonicMinor.isChecked());
            }
        });

        sbtMelodicMinor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                scaleSettingsValues.setMelodicMinor(sbtMelodicMinor.isChecked());
            }
        });

        sbtDorian.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                scaleSettingsValues.setDorian(sbtDorian.isChecked());
            }
        });

        sbtPhrygian.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                scaleSettingsValues.setPhrygian(sbtPhrygian.isChecked());
            }
        });

        sbtLydian.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                scaleSettingsValues.setLydian(sbtLydian.isChecked());
            }
        });

        sbtMixolydian.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                scaleSettingsValues.setMixolydian(sbtMixolydian.isChecked());
            }
        });

        sbtLocrian.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                scaleSettingsValues.setLocrian(sbtLocrian.isChecked());
            }
        });

        cbAscending.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                scaleSettingsValues.setAscending(cbAscending.isChecked());
            }
        });

        cbDescending.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                scaleSettingsValues.setDescending(cbDescending.isChecked());
            }
        });

    }

    private void setScaleSettings() {
        sbtMajorIonian.setChecked(scaleSettingsValues.isMajorIonian());
        sbtNaturalMinorAeolian.setChecked(scaleSettingsValues.isNaturalMinorAeolian());
        sbtHarmonicMinor.setChecked(scaleSettingsValues.isHarmonicMinor());
        sbtMelodicMinor.setChecked(scaleSettingsValues.isMelodicMinor());
        sbtDorian.setChecked(scaleSettingsValues.isDorian());
        sbtPhrygian.setChecked(scaleSettingsValues.isPhrygian());
        sbtLydian.setChecked(scaleSettingsValues.isLydian());
        sbtMixolydian.setChecked(scaleSettingsValues.isMixolydian());
        sbtLocrian.setChecked(scaleSettingsValues.isLocrian());
        cbAscending.setChecked(scaleSettingsValues.isAscending());
        cbDescending.setChecked(scaleSettingsValues.isDescending());
    }

    private void sendScaleSettingsValuesBack (ScaleSettings scaleSettingsValues) {
        if(callback != null) {
            callback.onScaleSettingsReturned(scaleSettingsValues);
        }
    }
}
