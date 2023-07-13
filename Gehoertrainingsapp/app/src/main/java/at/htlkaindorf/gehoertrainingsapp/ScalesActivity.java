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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import at.htlkaindorf.gehoertrainingsapp.beans.ScaleSettings;
import at.htlkaindorf.gehoertrainingsapp.beans.ScaleSettingsDialogCallback;

public class ScalesActivity extends AppCompatActivity implements ScaleSettingsDialogCallback {

    private Button btSkip;
    private TextView tvProgress;
    private Button btResetProgress;
    private ImageButton ibtPlayScale;
    private Button btMajorIonian;
    private Button btNaturalMinorAeolian;
    private Button btHarmonicMinor;
    private Button btMelodicMinor;
    private Button btDorian;
    private Button btPhrygian;
    private Button btLydian;
    private Button btMixolydian;
    private Button btLocrian;
    private Dialog scaleSettings;

    private ScaleSettings scaleSettingsValues;
    private int numberAttempts = 0;
    private int numberRights = 0;
    private String rightScale;
    private String randomScaleFile;

    private ArrayList<String> audioFiles = new ArrayList<>();
    private MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scales);

        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Typeface tf = Typeface.createFromAsset(getAssets(), "font/opensans_regular.ttf");

        Intent intent = getIntent();
        if(intent != null && intent.hasExtra("scaleSettings")) {
            scaleSettingsValues = (ScaleSettings) intent.getSerializableExtra("scaleSettings");
        }

        btSkip = findViewById(R.id.btSkip);
        tvProgress = findViewById(R.id.tvProgress);
        btResetProgress = findViewById(R.id.btResetProgress);
        ibtPlayScale = findViewById(R.id.ibtPlayScale);
        btMajorIonian = findViewById(R.id.btMajorIonian);
        btNaturalMinorAeolian = findViewById(R.id.btNaturalMinorAeolian);
        btHarmonicMinor = findViewById(R.id.btHarmonicMinor);
        btMelodicMinor = findViewById(R.id.btMelodicMinor);
        btDorian = findViewById(R.id.btDorian);
        btPhrygian = findViewById(R.id.btPhrygian);
        btLydian = findViewById(R.id.btLydian);
        btMixolydian = findViewById(R.id.btMixolydian);
        btLocrian = findViewById(R.id.btLocrian);

        btSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateRandomScale();
                enableDisableButtons();
            }
        });

        btResetProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberAttempts = 0;
                numberRights = 0;
                tvProgress.setText(numberRights + " / " + numberAttempts);
            }
        });

        ibtPlayScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSoundFile();
            }
        });

        btSkip.setTypeface(tf);
        tvProgress.setTypeface(tf);
        btResetProgress.setTypeface(tf);
        btMajorIonian.setTypeface(tf);
        btNaturalMinorAeolian.setTypeface(tf);
        btHarmonicMinor.setTypeface(tf);
        btMelodicMinor.setTypeface(tf);
        btDorian.setTypeface(tf);
        btPhrygian.setTypeface(tf);
        btLydian.setTypeface(tf);
        btMixolydian.setTypeface(tf);
        btLocrian.setTypeface(tf);

        btMajorIonian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRightScale("major_ionian")) {enableDisableButtons(); }
                else { btMajorIonian.setEnabled(false);}
                tvProgress.setText(numberRights + " / " + numberAttempts);
            }
        });
        btNaturalMinorAeolian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRightScale("natural_minor_aeolian")) {enableDisableButtons(); }
                else { btNaturalMinorAeolian.setEnabled(false);}
                tvProgress.setText(numberRights + " / " + numberAttempts);
            }
        });
        btHarmonicMinor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRightScale("harmonic_minor")) {enableDisableButtons(); }
                else { btHarmonicMinor.setEnabled(false);}
                tvProgress.setText(numberRights + " / " + numberAttempts);
            }
        });
        btMelodicMinor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRightScale("melodic_minor")) {enableDisableButtons(); }
                else { btMelodicMinor.setEnabled(false);}
                tvProgress.setText(numberRights + " / " + numberAttempts);
            }
        });
        btDorian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRightScale("dorian")) {enableDisableButtons(); }
                else { btDorian.setEnabled(false);}
                tvProgress.setText(numberRights + " / " + numberAttempts);
            }
        });
        btPhrygian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRightScale("phrygian")) {enableDisableButtons(); }
                else { btPhrygian.setEnabled(false);}
                tvProgress.setText(numberRights + " / " + numberAttempts);
            }
        });
        btLydian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRightScale("lydian")) {enableDisableButtons(); }
                else { btLydian.setEnabled(false);}
                tvProgress.setText(numberRights + " / " + numberAttempts);
            }
        });
        btMixolydian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRightScale("mixolydian")) {enableDisableButtons(); }
                else { btMixolydian.setEnabled(false);}
                tvProgress.setText(numberRights + " / " + numberAttempts);
            }
        });
        btLocrian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRightScale("locrian")) {enableDisableButtons(); }
                else { btLocrian.setEnabled(false);}
                tvProgress.setText(numberRights + " / " + numberAttempts);
            }
        });

        enableDisableButtons();
        generateRandomScale();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            mediaPlayer.seekTo(0);
        }
    }

    private void generateRandomScale() {
        List<String> possibleScaleList = scaleSettingsValues.getPossibleScaleList();
        List<String> possiblePlayMode = scaleSettingsValues.getPossiblePlayMode();

        Random rand = new Random();
        rightScale = possibleScaleList.get(rand.nextInt(possibleScaleList.size()));
        String playMode = possiblePlayMode.get(rand.nextInt(possiblePlayMode.size()));

        String filename = "audio/scales/" + rightScale + "/" + playMode;

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
        randomScaleFile = filename + "/" + audioFiles.get(randomIndex);

        mediaPlayer.reset();
        try {
            AssetFileDescriptor assetFileDescriptor = assetManager.openFd(randomScaleFile);
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

    public boolean isRightScale(String clickedButton) {
        numberAttempts++;
        if(clickedButton.equals(rightScale)) {
            numberRights++;
            generateRandomScale();
            return true;
        }
        return false;
    }

    public void openScaleSettings(View v) {
        scaleSettings = new ScaleSettingsDialog(this, scaleSettingsValues, this);
        scaleSettings.setContentView(R.layout.activity_scale_pop_up);
        scaleSettings.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        scaleSettings.getWindow().setDimAmount(0.8f);
        scaleSettings.setCanceledOnTouchOutside(true);
        scaleSettings.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                onScaleSettingsReturned(scaleSettingsValues);
            }
        });
        scaleSettings.show();
    }

    public void openScaleTheory(View v) {
        Intent intent = new Intent(ScalesActivity.this, ScaleTheoryActivity.class);
        startActivity(intent);
    }

    @Override
    public void onScaleSettingsReturned(ScaleSettings scaleSettingsValues) {
        if(scaleSettingsValues.allIntervalFalse()) {
            scaleSettingsValues.setMajorIonian(true);
            scaleSettingsValues.setNaturalMinorAeolian(true);
        }
        if(scaleSettingsValues.allPlayModeFalse()) {
            scaleSettingsValues.setAscending(true);
        }

        this.scaleSettingsValues = scaleSettingsValues;
        enableDisableButtons();
        generateRandomScale();
    }

    private void enableDisableButtons() {
        if(scaleSettingsValues.isMajorIonian()) { btMajorIonian.setEnabled(true);} else {btMajorIonian.setEnabled(false);}
        if(scaleSettingsValues.isNaturalMinorAeolian()) { btNaturalMinorAeolian.setEnabled(true);} else {btNaturalMinorAeolian.setEnabled(false);}
        if(scaleSettingsValues.isHarmonicMinor()) { btHarmonicMinor.setEnabled(true);} else {btHarmonicMinor.setEnabled(false);}
        if(scaleSettingsValues.isMelodicMinor()) { btMelodicMinor.setEnabled(true);} else {btMelodicMinor.setEnabled(false);}
        if(scaleSettingsValues.isDorian()) { btDorian.setEnabled(true);} else {btDorian.setEnabled(false);}
        if(scaleSettingsValues.isPhrygian()) { btPhrygian.setEnabled(true);} else {btPhrygian.setEnabled(false);}
        if(scaleSettingsValues.isLydian()) { btLydian.setEnabled(true);} else {btLydian.setEnabled(false);}
        if(scaleSettingsValues.isMixolydian()) { btMixolydian.setEnabled(true);} else {btMixolydian.setEnabled(false);}
        if(scaleSettingsValues.isLocrian()) { btLocrian.setEnabled(true);} else {btLocrian.setEnabled(false);}
    }
}