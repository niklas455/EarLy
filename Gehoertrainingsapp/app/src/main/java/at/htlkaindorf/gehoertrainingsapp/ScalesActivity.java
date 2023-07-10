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

import at.htlkaindorf.gehoertrainingsapp.beans.ChordSettings;
import at.htlkaindorf.gehoertrainingsapp.beans.ScaleSettings;
import at.htlkaindorf.gehoertrainingsapp.beans.ScaleSettingsDialogCallback;

public class ScalesActivity extends AppCompatActivity implements ScaleSettingsDialogCallback {

    private TextView tvProgress;
    private Button btResetProgress;
    private ImageButton ibtPlayScale;
    private Button btMajorScale;
    private Button btNaturalMinorScale;
    private Button btHarmonicMinorScale;
    private Button btMelodicMinorScale;
    private Dialog scaleSettings;

    private Typeface tf;
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

        tf = Typeface.createFromAsset(getAssets(), "font/opensans_regular.ttf");

        Intent intent = getIntent();
        if(intent != null && intent.hasExtra("scaleSettings")) {
            scaleSettingsValues = (ScaleSettings) intent.getSerializableExtra("scaleSettings");
        }

        tvProgress = findViewById(R.id.tvProgress);
        btResetProgress = findViewById(R.id.btResetProgress);
        ibtPlayScale = findViewById(R.id.ibtPlayScale);
        btMajorScale = findViewById(R.id.btMajorScale);
        btNaturalMinorScale = findViewById(R.id.btNaturalMinorScale);
        btHarmonicMinorScale = findViewById(R.id.btHarmonicMinorScale);
        btMelodicMinorScale = findViewById(R.id.btMelodicMinorScale);

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

        tvProgress.setTypeface(tf);
        btResetProgress.setTypeface(tf);
        btMajorScale.setTypeface(tf);
        btNaturalMinorScale.setTypeface(tf);
        btHarmonicMinorScale.setTypeface(tf);
        btMelodicMinorScale.setTypeface(tf);

        btMajorScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRightScale("majorscale")) {enableDisableButtons(); }
                else { btMajorScale.setEnabled(false);}
                tvProgress.setText(numberRights + " / " + numberAttempts);
            }
        });
        btNaturalMinorScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRightScale("naturalminorscale")) {enableDisableButtons(); }
                else { btNaturalMinorScale.setEnabled(false);}
                tvProgress.setText(numberRights + " / " + numberAttempts);
            }
        });
        btHarmonicMinorScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRightScale("harmonicminorscale")) {enableDisableButtons(); }
                else { btHarmonicMinorScale.setEnabled(false);}
                tvProgress.setText(numberRights + " / " + numberAttempts);
            }
        });
        btMelodicMinorScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRightScale("melodicminorscale")) {enableDisableButtons(); }
                else { btMelodicMinorScale.setEnabled(false);}
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
            mediaPlayer.stop();
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

    @Override
    public void onScaleSettingsReturned(ScaleSettings scaleSettingsValues) {
        if(scaleSettingsValues.allIntervalFalse()) {
            scaleSettingsValues.setMajor(true);
            scaleSettingsValues.setNaturalMinor(true);
        }
        if(scaleSettingsValues.allPlayModeFalse()) {
            scaleSettingsValues.setAscending(true);
        }

        this.scaleSettingsValues = scaleSettingsValues;
        enableDisableButtons();
        generateRandomScale();
    }

    private void enableDisableButtons() {
        if(scaleSettingsValues.isMajor()) { btMajorScale.setEnabled(true);} else {btMajorScale.setEnabled(false);}
        if(scaleSettingsValues.isNaturalMinor()) { btNaturalMinorScale.setEnabled(true);} else {btNaturalMinorScale.setEnabled(false);}
        if(scaleSettingsValues.isHarmonicMinor()) { btHarmonicMinorScale.setEnabled(true);} else {btHarmonicMinorScale.setEnabled(false);}
        if(scaleSettingsValues.isMelodicMinor()) { btMelodicMinorScale.setEnabled(true);} else {btMelodicMinorScale.setEnabled(false);}
    }
}