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
import at.htlkaindorf.gehoertrainingsapp.beans.ChordSettingsDialogCallback;

public class ChordsActivity extends AppCompatActivity implements ChordSettingsDialogCallback {

    private ImageButton ibtPlayChord;
    private Button btMajor;
    private Button btMinor;
    private Button btAugmented;
    private Button btDiminished;
    private Button btDominant7th;
    private Button btMajor7th;
    private Button btMinor7th;
    private Button btDiminished7th;
    private Dialog chordSettings;

    private Typeface tf;
    private ChordSettings chordSettingsValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chords);

        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        tf = Typeface.createFromAsset(getAssets(), "font/opensans_regular.ttf");

        Intent intent = getIntent();
        if(intent != null && intent.hasExtra("chordSettings")) {
            chordSettingsValues = (ChordSettings) intent.getSerializableExtra("chordSettings");
        }

        ibtPlayChord = findViewById(R.id.ibtPlayChord);
        btMajor = findViewById(R.id.btMajor);
        btMinor = findViewById(R.id.btMinor);
        btAugmented = findViewById(R.id.btAugmented);
        btDiminished = findViewById(R.id.btDiminished);
        btDominant7th = findViewById(R.id.btDominant7th);
        btMajor7th = findViewById(R.id.btMajor7thChord);
        btMinor7th = findViewById(R.id.btMinor7thChord);
        btDiminished7th = findViewById(R.id.btDiminished7th);

        ibtPlayChord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btMajor.setTypeface(tf);
        btMinor.setTypeface(tf);
        btAugmented.setTypeface(tf);
        btDiminished.setTypeface(tf);
        btDominant7th.setTypeface(tf);
        btMajor7th.setTypeface(tf);
        btMinor7th.setTypeface(tf);
        btDiminished7th.setTypeface(tf);

        btMajor.setOnClickListener(onClickChord);
        btMinor.setOnClickListener(onClickChord);
        btAugmented.setOnClickListener(onClickChord);
        btDiminished.setOnClickListener(onClickChord);
        btDominant7th.setOnClickListener(onClickChord);
        btMajor7th.setOnClickListener(onClickChord);
        btMinor7th.setOnClickListener(onClickChord);
        btDiminished7th.setOnClickListener(onClickChord);

        enableDisableButtons(chordSettingsValues);
    }

    private View.OnClickListener onClickChord = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btMajor:
                    System.out.println("Major");
                    break;
                case R.id.btMinor:
                    System.out.println("Minor");
                    break;
                case R.id.btAugmented:
                    System.out.println("Augmented");
                    break;
                case R.id.btDiminished:
                    System.out.println("Diminished");
                    break;
                case R.id.btDominant7th:
                    System.out.println("Dominant 7th");
                    break;
                case R.id.btMajor7thChord:
                    System.out.println("Major 7th");
                    break;
                case R.id.btMinor7thChord:
                    System.out.println("Minor 7th");
                    break;
                case R.id.btDiminished7th:
                    System.out.println("Diminished 7th");
                    break;
            }
        }
    };

    public void openChordSettings(View v) {
        chordSettings = new ChordSettingsDialog(this, chordSettingsValues, this);
        chordSettings.setContentView(R.layout.activity_chord_pop_up);
        chordSettings.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        chordSettings.getWindow().setDimAmount(0.8f);
        chordSettings.setCanceledOnTouchOutside(true);
        chordSettings.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                onChordSettingsReturned(chordSettingsValues);
            }
        });
        chordSettings.show();
    }

    @Override
    public void onChordSettingsReturned(ChordSettings chordSettingsValues) {
        if(chordSettingsValues.allIntervalFalse()) {
            chordSettingsValues.setMajor(true);
            chordSettingsValues.setMinor(true);
        }
        if(chordSettingsValues.allPlayModeFalse()) {
            chordSettingsValues.setHarmonic(true);
        }

        enableDisableButtons(chordSettingsValues);
        this.chordSettingsValues = chordSettingsValues;
    }

    private void enableDisableButtons(ChordSettings chordSettingsValues) {
        if(chordSettingsValues.isMajor()) { btMajor.setEnabled(true);} else {btMajor.setEnabled(false);}
        if(chordSettingsValues.isMinor()) { btMinor.setEnabled(true);} else {btMinor.setEnabled(false);}
        if(chordSettingsValues.isAugmented()) { btAugmented.setEnabled(true);} else {btAugmented.setEnabled(false);}
        if(chordSettingsValues.isDiminished()) { btDiminished.setEnabled(true);} else {btDiminished.setEnabled(false);}
        if(chordSettingsValues.isDominant7th()) { btDominant7th.setEnabled(true);} else {btDominant7th.setEnabled(false);}
        if(chordSettingsValues.isMajor7th()) { btMajor7th.setEnabled(true);} else {btMajor7th.setEnabled(false);}
        if(chordSettingsValues.isMinor7th()) { btMinor7th.setEnabled(true);} else {btMinor7th.setEnabled(false);}
        if(chordSettingsValues.isDiminished7th()) { btDiminished7th.setEnabled(true);} else {btDiminished7th.setEnabled(false);}
    }
}