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

public class ChordsActivity extends AppCompatActivity {

    private ImageButton ibtPlayChord;
    private Button btMajor;
    private Button btMinor;
    private Button btAugmented;
    private Button btDiminished;
    private Dialog chordSettings;

    private Typeface tf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chords);
        chordSettings = new Dialog(this);

        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        tf = Typeface.createFromAsset(getAssets(), "font/opensans_regular.ttf");

        ibtPlayChord = findViewById(R.id.ibtPlayChord);
        ibtPlayChord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btMajor = findViewById(R.id.btMajor);
        btMajor.setTypeface(tf);
        btMajor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btMinor = findViewById(R.id.btMinor);
        btMinor.setTypeface(tf);
        btMinor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btAugmented = findViewById(R.id.btAugmented);
        btAugmented.setTypeface(tf);
        btAugmented.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btDiminished = findViewById(R.id.btDiminished);
        btDiminished.setTypeface(tf);
        btDiminished.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void openChordSettings(View v) {
        chordSettings.setContentView(R.layout.activity_chord_pop_up);
        chordSettings.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        chordSettings.show();
    }
}