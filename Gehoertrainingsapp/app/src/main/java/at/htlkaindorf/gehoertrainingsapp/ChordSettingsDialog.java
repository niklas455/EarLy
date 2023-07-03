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
    private Switch sbtDominant7th;
    private Switch sbtMajor7th;
    private Switch sbtMinor7th;
    private Switch sbtDiminished7th;
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
        sbtDominant7th = findViewById(R.id.sbtDominant7th);
        sbtMajor7th = findViewById(R.id.sbtMajor7thChord);
        sbtMinor7th = findViewById(R.id.sbtMinor7thChord);
        sbtDiminished7th = findViewById(R.id.sbtDiminished7th);
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

        sbtDominant7th.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                chordSettingsValues.setDominant7th(sbtDominant7th.isChecked());
            }
        });

        sbtMajor7th.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                chordSettingsValues.setMajor7th(sbtMajor7th.isChecked());
            }
        });

        sbtMinor7th.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                chordSettingsValues.setMinor7th(sbtMinor7th.isChecked());
            }
        });

        sbtDiminished7th.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                chordSettingsValues.setDiminished7th(sbtDiminished7th.isChecked());
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
        sbtDominant7th.setChecked(chordSettingsValues.isDominant7th());
        sbtMajor7th.setChecked(chordSettingsValues.isMajor7th());
        sbtMinor7th.setChecked(chordSettingsValues.isMinor7th());
        sbtDiminished7th.setChecked(chordSettingsValues.isDiminished7th());
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
