package at.htlkaindorf.gehoertrainingsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import at.htlkaindorf.gehoertrainingsapp.beans.ChordSettings;
import at.htlkaindorf.gehoertrainingsapp.beans.ChordSettingsDialogCallback;

public class ChordsActivity extends AppCompatActivity implements ChordSettingsDialogCallback {

    private TextView tvProgress;
    private Button btResetProgress;
    private ImageButton ibtPlayChord;
    private Button btMajor;
    private Button btMinor;
    private Button btAugmented;
    private Button btDiminished;
    private Button btMajor7th;
    private Button btMinor7th;
    private Button btDominant7th;
    private Button btMinorMaj7th;
    private Button btHalfDim7th;
    private Button btDiminished7th;
    private Dialog chordSettings;

    private Typeface tf;
    private ChordSettings chordSettingsValues;
    private int numberAttempts = 0;
    private int numberRights = 0;
    private String rightChord;
    private String randomChordFile;

    private ArrayList<String> audioFiles = new ArrayList<>();
    private MediaPlayer mediaPlayer = new MediaPlayer();

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

        tvProgress = findViewById(R.id.tvProgress);
        btResetProgress = findViewById(R.id.btResetProgress);
        ibtPlayChord = findViewById(R.id.ibtPlayChord);
        btMajor = findViewById(R.id.btMajor);
        btMinor = findViewById(R.id.btMinor);
        btAugmented = findViewById(R.id.btAugmented);
        btDiminished = findViewById(R.id.btDiminished);
        btMajor7th = findViewById(R.id.btMajor7thChord);
        btMinor7th = findViewById(R.id.btMinor7thChord);
        btDominant7th = findViewById(R.id.btDominant7th);
        btMinorMaj7th = findViewById(R.id.btMinorMaj7th);
        btHalfDim7th = findViewById(R.id.btHalfDim7th);
        btDiminished7th = findViewById(R.id.btDiminished7th);

        btResetProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberAttempts = 0;
                numberRights = 0;
                tvProgress.setText(numberRights + " / " + numberAttempts);
            }
        });

        ibtPlayChord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSoundFile();
            }
        });

        tvProgress.setTypeface(tf);
        btResetProgress.setTypeface(tf);
        btMajor.setTypeface(tf);
        btMinor.setTypeface(tf);
        btAugmented.setTypeface(tf);
        btDiminished.setTypeface(tf);
        btMajor7th.setTypeface(tf);
        btMinor7th.setTypeface(tf);
        btDominant7th.setTypeface(tf);
        btMinorMaj7th.setTypeface(tf);
        btHalfDim7th.setTypeface(tf);
        btDiminished7th.setTypeface(tf);

        btMajor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRightChord("major")) {enableDisableButtons(); }
                else { btMajor.setEnabled(false);}
                tvProgress.setText(numberRights + " / " + numberAttempts);
            }
        });
        btMinor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRightChord("minor")) {enableDisableButtons(); }
                else { btMinor.setEnabled(false);}
                tvProgress.setText(numberRights + " / " + numberAttempts);
            }
        });
        btAugmented.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRightChord("augmented")) {enableDisableButtons(); }
                else { btAugmented.setEnabled(false);}
                tvProgress.setText(numberRights + " / " + numberAttempts);
            }
        });
        btDiminished.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRightChord("diminished")) {enableDisableButtons(); }
                else { btDiminished.setEnabled(false);}
                tvProgress.setText(numberRights + " / " + numberAttempts);
            }
        });
        btMajor7th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRightChord("major7th")) {enableDisableButtons(); }
                else { btMajor7th.setEnabled(false);}
                tvProgress.setText(numberRights + " / " + numberAttempts);
            }
        });
        btMinor7th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRightChord("minor7th")) {enableDisableButtons(); }
                else { btMinor7th.setEnabled(false);}
                tvProgress.setText(numberRights + " / " + numberAttempts);
            }
        });
        btDominant7th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRightChord("dominant7th")) {enableDisableButtons(); }
                else { btDominant7th.setEnabled(false);}
                tvProgress.setText(numberRights + " / " + numberAttempts);
            }
        });
        btMinorMaj7th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRightChord("minormaj7th")) {enableDisableButtons(); }
                else { btMinorMaj7th.setEnabled(false);}
                tvProgress.setText(numberRights + " / " + numberAttempts);
            }
        });
        btHalfDim7th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRightChord("halfdim7th")) {enableDisableButtons(); }
                else { btHalfDim7th.setEnabled(false);}
                tvProgress.setText(numberRights + " / " + numberAttempts);
            }
        });
        btDiminished7th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRightChord("diminished7th")) {enableDisableButtons(); }
                else { btDiminished7th.setEnabled(false);}
                tvProgress.setText(numberRights + " / " + numberAttempts);
            }
        });

        enableDisableButtons();
        generateRandomChord();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
    }

    private void generateRandomChord() {
        List<String> possibleChordList = chordSettingsValues.getPossibleChordList();
        List<String> possiblePlayMode = chordSettingsValues.getPossiblePlayMode();

        Random rand = new Random();
        rightChord = possibleChordList.get(rand.nextInt(possibleChordList.size()));
        String playMode = possiblePlayMode.get(rand.nextInt(possiblePlayMode.size()));

        String filename = "audio/chords/" + rightChord + "/" + playMode;

        audioFiles.clear();
        AssetManager assetManager = getAssets();
        try {
            String[] files = assetManager.list(filename);
            for (String file : files) {
                if (file.endsWith(".mp3")) {
                    audioFiles.add(file);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Random random = new Random();

        int randomIndex = random.nextInt(audioFiles.size());
        randomChordFile = filename + "/" + audioFiles.get(randomIndex);

        mediaPlayer.reset();
        try {
            AssetFileDescriptor assetFileDescriptor = assetManager.openFd(randomChordFile);
            mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.start();
    }

    private void playSoundFile() {
        if (mediaPlayer.isPlaying()) {mediaPlayer.seekTo(0);}
        mediaPlayer.start();
    }

    public boolean isRightChord(String clickedButton) {
        numberAttempts++;
        if(clickedButton.equals(rightChord)) {
            numberRights++;
            generateRandomChord();
            return true;
        }
        return false;
    }

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

        this.chordSettingsValues = chordSettingsValues;
        enableDisableButtons();
        generateRandomChord();
    }

    private void enableDisableButtons() {
        if(chordSettingsValues.isMajor()) { btMajor.setEnabled(true);} else {btMajor.setEnabled(false);}
        if(chordSettingsValues.isMinor()) { btMinor.setEnabled(true);} else {btMinor.setEnabled(false);}
        if(chordSettingsValues.isAugmented()) { btAugmented.setEnabled(true);} else {btAugmented.setEnabled(false);}
        if(chordSettingsValues.isDiminished()) { btDiminished.setEnabled(true);} else {btDiminished.setEnabled(false);}
        if(chordSettingsValues.isMajor7th()) { btMajor7th.setEnabled(true);} else {btMajor7th.setEnabled(false);}
        if(chordSettingsValues.isMinor7th()) { btMinor7th.setEnabled(true);} else {btMinor7th.setEnabled(false);}
        if(chordSettingsValues.isDominant7th()) { btDominant7th.setEnabled(true);} else {btDominant7th.setEnabled(false);}
        if(chordSettingsValues.isMinorMaj7th()) { btMinorMaj7th.setEnabled(true);} else {btMinorMaj7th.setEnabled(false);}
        if(chordSettingsValues.isHalfDim7th()) { btHalfDim7th.setEnabled(true);} else {btHalfDim7th.setEnabled(false);}
        if(chordSettingsValues.isDiminished7th()) { btDiminished7th.setEnabled(true);} else {btDiminished7th.setEnabled(false);}
    }
}