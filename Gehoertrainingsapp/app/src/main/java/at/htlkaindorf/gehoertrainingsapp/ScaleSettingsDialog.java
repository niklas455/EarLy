package at.htlkaindorf.gehoertrainingsapp;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.annotation.NonNull;

import at.htlkaindorf.gehoertrainingsapp.beans.ChordSettings;
import at.htlkaindorf.gehoertrainingsapp.beans.ScaleSettings;
import at.htlkaindorf.gehoertrainingsapp.beans.ScaleSettingsDialogCallback;

public class ScaleSettingsDialog extends Dialog {

    private Switch sbtMajorScale;
    private Switch sbtNaturalMinorScale;
    private Switch sbtHarmonicMinorScale;
    private Switch sbtMelodicMinorScale;
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

        sbtMajorScale = findViewById(R.id.sbtMajorScale);
        sbtNaturalMinorScale = findViewById(R.id.sbtNaturalMinorScale);
        sbtHarmonicMinorScale = findViewById(R.id.sbtHarmonicMinorScale);
        sbtMelodicMinorScale = findViewById(R.id.sbtMelodicMinorScale);
        cbAscending = findViewById(R.id.cbAscending);
        cbDescending = findViewById(R.id.cbDescending);

        setScaleSettings();

        sbtMajorScale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                scaleSettingsValues.setMajor(sbtMajorScale.isChecked());
            }
        });

        sbtNaturalMinorScale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                scaleSettingsValues.setNaturalMinor(sbtNaturalMinorScale.isChecked());
            }
        });

        sbtHarmonicMinorScale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                scaleSettingsValues.setHarmonicMinor(sbtHarmonicMinorScale.isChecked());
            }
        });

        sbtMelodicMinorScale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                scaleSettingsValues.setMelodicMinor(sbtMelodicMinorScale.isChecked());
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
        sbtMajorScale.setChecked(scaleSettingsValues.isMajor());
        sbtNaturalMinorScale.setChecked(scaleSettingsValues.isNaturalMinor());
        sbtHarmonicMinorScale.setChecked(scaleSettingsValues.isHarmonicMinor());
        sbtMelodicMinorScale.setChecked(scaleSettingsValues.isMelodicMinor());
        cbAscending.setChecked(scaleSettingsValues.isAscending());
        cbDescending.setChecked(scaleSettingsValues.isDescending());
    }

    private void sendScaleSettingsValuesBack (ScaleSettings scaleSettingsValues) {
        if(callback != null) {
            callback.onScaleSettingsReturned(scaleSettingsValues);
        }
    }
}
