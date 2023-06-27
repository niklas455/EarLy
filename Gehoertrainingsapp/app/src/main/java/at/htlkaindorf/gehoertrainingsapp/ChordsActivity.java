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
        btMinor = findViewById(R.id.btMinor);
        btAugmented = findViewById(R.id.btAugmented);
        btDiminished = findViewById(R.id.btDiminished);

        btMajor.setTypeface(tf);
        btMinor.setTypeface(tf);
        btAugmented.setTypeface(tf);
        btDiminished.setTypeface(tf);

        btMajor.setOnClickListener(onClickChord);
        btMinor.setOnClickListener(onClickChord);
        btAugmented.setOnClickListener(onClickChord);
        btDiminished.setOnClickListener(onClickChord);
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
            }
        }
    };

    public void openChordSettings(View v) {
        chordSettings.setContentView(R.layout.activity_chord_pop_up);
        chordSettings.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        chordSettings.show();
    }
}