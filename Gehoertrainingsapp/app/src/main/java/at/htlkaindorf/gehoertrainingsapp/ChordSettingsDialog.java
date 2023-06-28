package at.htlkaindorf.gehoertrainingsapp;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.annotation.NonNull;

import at.htlkaindorf.gehoertrainingsapp.beans.ChordSettings;
import at.htlkaindorf.gehoertrainingsapp.beans.ChordSettingsDialogCallback;

public class ChordSettingsDialog extends Dialog {

    private Switch sbtMajor;
    private Switch sbtMinor;
    private Switch sbtAugmented;
    private Switch sbtDiminished;
    private CheckBox cbAscending;
    private CheckBox cbDescending;
    private CheckBox cbHarmonic;

    private ChordSettings chordSettingsValues;
    private ChordSettingsDialogCallback callback;

    public ChordSettingsDialog(@NonNull Context context, ChordSettings chordSettingsValues, ChordSettingsDialogCallback callback) {
        super(context);
        this.chordSettingsValues = chordSettingsValues;
        this.callback = callback;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chord_pop_up);

        sbtMajor = findViewById(R.id.sbtMajor);
        sbtMinor = findViewById(R.id.sbtMinor);
        sbtAugmented = findViewById(R.id.sbtAugmented);
        sbtDiminished = findViewById(R.id.sbtDiminished);
        cbAscending = findViewById(R.id.cbAscending);
        cbDescending = findViewById(R.id.cbDescending);
        cbHarmonic = findViewById(R.id.cbHarmonic);

        setChordSettings();

        sbtMajor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                chordSettingsValues.setMajor(sbtMajor.isChecked());
            }
        });

        sbtMinor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                chordSettingsValues.setMinor(sbtMinor.isChecked());
            }
        });

        sbtAugmented.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                chordSettingsValues.setAugmented(sbtAugmented.isChecked());
            }
        });

        sbtDiminished.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                chordSettingsValues.setDiminished(sbtDiminished.isChecked());
            }
        });

        cbAscending.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                chordSettingsValues.setAscending(cbAscending.isChecked());
            }
        });

        cbDescending.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                chordSettingsValues.setDescending(cbDescending.isChecked());
            }
        });

        cbHarmonic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                chordSettingsValues.setHarmonic(cbHarmonic.isChecked());
            }
        });

    }

    private void setChordSettings() {
        sbtMajor.setChecked(chordSettingsValues.isMajor());
        sbtMinor.setChecked(chordSettingsValues.isMinor());
        sbtAugmented.setChecked(chordSettingsValues.isAugmented());
        sbtDiminished.setChecked(chordSettingsValues.isDiminished());
        cbAscending.setChecked(chordSettingsValues.isAscending());
        cbDescending.setChecked(chordSettingsValues.isDescending());
        cbHarmonic.setChecked(chordSettingsValues.isHarmonic());
    }

    private void sendChordSettingsValuesBack (ChordSettings chordSettingsValues) {
        if(callback != null) {
            callback.onChordSettingsReturned(chordSettingsValues);
        }
    }
}
