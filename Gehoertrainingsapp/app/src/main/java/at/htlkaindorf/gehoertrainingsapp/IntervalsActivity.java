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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import at.htlkaindorf.gehoertrainingsapp.beans.IntervalSettings;
import at.htlkaindorf.gehoertrainingsapp.beans.IntervalSettingsDialogCallback;

public class IntervalsActivity extends AppCompatActivity implements IntervalSettingsDialogCallback {

    private ImageButton ibtPlayInterval;
    private Button btUnison;
    private Button btMinor2nd;
    private Button btMajor2nd;
    private Button btMinor3rd;
    private Button btMajor3rd;
    private Button btPerfect4th;
    private Button btTritone;
    private Button btPerfect5th;
    private Button btMinor6th;
    private Button btMajor6th;
    private Button btMinor7th;
    private Button btMajor7th;
    private Button btOctave;
    private Dialog intervalSettings;

    private Typeface tf;
    private IntervalSettings intervalSettingsValues;
    private String rightInterval;
    private String randomIntervalFile;

    private ArrayList<String> audioFiles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intervals);

        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        tf = Typeface.createFromAsset(getAssets(), "font/opensans_regular.ttf");

        Intent intent = getIntent();
        if(intent != null && intent.hasExtra("intervalSettings")) {
            intervalSettingsValues = (IntervalSettings) intent.getSerializableExtra("intervalSettings");
        }

        ibtPlayInterval = findViewById(R.id.ibtPlayInterval);
        btUnison = findViewById(R.id.btUnison);
        btMinor2nd = findViewById(R.id.btMinor2nd);
        btMajor2nd = findViewById(R.id.btMajor2nd);
        btMinor3rd = findViewById(R.id.btMinor3rd);
        btMajor3rd = findViewById(R.id.btMajor3rd);
        btPerfect4th = findViewById(R.id.btPerfect4th);
        btTritone = findViewById(R.id.btTritone);
        btPerfect5th = findViewById(R.id.btPerfect5th);
        btMinor6th = findViewById(R.id.btMinor6th);
        btMajor6th = findViewById(R.id.btMajor6th);
        btMinor7th = findViewById(R.id.btMinor7th);
        btMajor7th = findViewById(R.id.btMajor7th);
        btOctave = findViewById(R.id.btOctave);

        ibtPlayInterval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSoundFile();
            }
        });

        btUnison.setTypeface(tf);
        btMinor2nd.setTypeface(tf);
        btMajor2nd.setTypeface(tf);
        btMinor3rd.setTypeface(tf);
        btMajor3rd.setTypeface(tf);
        btPerfect4th.setTypeface(tf);
        btTritone.setTypeface(tf);
        btPerfect5th.setTypeface(tf);
        btMinor6th.setTypeface(tf);
        btMajor6th.setTypeface(tf);
        btMinor7th.setTypeface(tf);
        btMajor7th.setTypeface(tf);
        btOctave.setTypeface(tf);

        btUnison.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRightInterval("unison")) {enableDisableButtons(); }
                else { btUnison.setEnabled(false);}
            }
        });
        btMinor2nd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRightInterval("minor2nd")) {enableDisableButtons(); }
                else { btMinor2nd.setEnabled(false);}
            }
        });
        btMajor2nd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRightInterval("major2nd")) {enableDisableButtons(); }
                else { btMajor2nd.setEnabled(false);}
            }
        });
        btMinor3rd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRightInterval("minor3rd")) {enableDisableButtons(); }
                else { btMinor3rd.setEnabled(false);}
            }
        });
        btMajor3rd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRightInterval("major3rd")) {enableDisableButtons(); }
                else { btMajor3rd.setEnabled(false);}
            }
        });
        btPerfect4th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRightInterval("perfect4th")) {enableDisableButtons(); }
                else { btPerfect4th.setEnabled(false);}
            }
        });
        btTritone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRightInterval("tritone")) {enableDisableButtons(); }
                else { btTritone.setEnabled(false);}
            }
        });
        btPerfect5th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRightInterval("perfect5th")) {enableDisableButtons(); }
                else { btPerfect5th.setEnabled(false);}
            }
        });
        btMinor6th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRightInterval("minor6th")) {enableDisableButtons(); }
                else { btMinor6th.setEnabled(false);}
            }
        });
        btMajor6th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRightInterval("major6th")) {enableDisableButtons(); }
                else { btMajor6th.setEnabled(false);}
            }
        });
        btMinor7th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRightInterval("minor7th")) {enableDisableButtons(); }
                else { btMinor7th.setEnabled(false);}
            }
        });
        btMajor7th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRightInterval("major7th")) {enableDisableButtons(); }
                else { btMajor7th.setEnabled(false);}
            }
        });
        btOctave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRightInterval("octave")) {enableDisableButtons(); }
                else { btOctave.setEnabled(false);}
            }
        });

        enableDisableButtons();
        generateRandomInterval();
        playSoundFile();
    }

    private void generateRandomInterval() {
        List<String> possibleIntervalList = intervalSettingsValues.getPossibleIntervalList();
        List<String> possiblePlayMode = intervalSettingsValues.getPossiblePlayMode();
        String filename = "";

        Random rand = new Random();
        rightInterval = possibleIntervalList.get(rand.nextInt(possibleIntervalList.size()));
        String playMode = possiblePlayMode.get(rand.nextInt(possiblePlayMode.size()));

        if(rightInterval.equals("unison")) {
            filename = "audio/intervals/" + rightInterval;
        } else {
            filename = "audio/intervals/" + rightInterval + "/" + playMode;
        }

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
        randomIntervalFile = filename + "/" + audioFiles.get(randomIndex);
        System.out.println(randomIntervalFile + "********************************************************************************++");
    }

    // test method
    private void playSoundFile() {
        AssetManager assetManager = getAssets();
        MediaPlayer mediaPlayer = new MediaPlayer();

        try {
            AssetFileDescriptor assetFileDescriptor = assetManager.openFd(randomIntervalFile);
            mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
            mediaPlayer.prepare();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    ibtPlayInterval.setEnabled(true);
                    mediaPlayer.release();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        ibtPlayInterval.setEnabled(false);
        mediaPlayer.start();
    }

    public boolean isRightInterval(String clickedButton) {
        if(clickedButton.equals(rightInterval)) {
            generateRandomInterval();
            playSoundFile();
            return true;
        }
        return false;
    }

    public void openIntervalSettings(View v) {
        intervalSettings = new IntervalSettingsDialog(this, intervalSettingsValues, this);
        intervalSettings.setContentView(R.layout.activity_interval_pop_up);
        intervalSettings.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        intervalSettings.getWindow().setDimAmount(0.8f);
        intervalSettings.setCanceledOnTouchOutside(true);
        intervalSettings.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                onIntervalSettingsReturned(intervalSettingsValues);
            }
        });
        intervalSettings.show();
    }

    @Override
    public void onIntervalSettingsReturned(IntervalSettings intervalSettingsValues) {
        if(intervalSettingsValues.allIntervalFalse()) {
            intervalSettingsValues.setMajor2nd(true);
            intervalSettingsValues.setMajor3rd(true);
            intervalSettingsValues.setPerfect4th(true);
            intervalSettingsValues.setPerfect5th(true);
        }
        if(intervalSettingsValues.allPlayModeFalse()) {
            intervalSettingsValues.setAscending(true);
        }

        this.intervalSettingsValues = intervalSettingsValues;
        enableDisableButtons();
        generateRandomInterval();
        playSoundFile();
    }

    private void enableDisableButtons() {
        if(intervalSettingsValues.isUnison()) { btUnison.setEnabled(true);} else {btUnison.setEnabled(false);}
        if(intervalSettingsValues.isMinor2nd()) { btMinor2nd.setEnabled(true);} else {btMinor2nd.setEnabled(false);}
        if(intervalSettingsValues.isMajor2nd()) { btMajor2nd.setEnabled(true);} else {btMajor2nd.setEnabled(false);}
        if(intervalSettingsValues.isMinor3rd()) { btMinor3rd.setEnabled(true);} else {btMinor3rd.setEnabled(false);}
        if(intervalSettingsValues.isMajor3rd()) { btMajor3rd.setEnabled(true);} else {btMajor3rd.setEnabled(false);}
        if(intervalSettingsValues.isPerfect4th()) { btPerfect4th.setEnabled(true);} else {btPerfect4th.setEnabled(false);}
        if(intervalSettingsValues.isTriton()) { btTritone.setEnabled(true);} else {btTritone.setEnabled(false);}
        if(intervalSettingsValues.isPerfect5th()) { btPerfect5th.setEnabled(true);} else {btPerfect5th.setEnabled(false);}
        if(intervalSettingsValues.isMinor6th()) { btMinor6th.setEnabled(true);} else {btMinor6th.setEnabled(false);}
        if(intervalSettingsValues.isMajor6th()) { btMajor6th.setEnabled(true);} else {btMajor6th.setEnabled(false);}
        if(intervalSettingsValues.isMinor7th()) { btMinor7th.setEnabled(true);} else {btMinor7th.setEnabled(false);}
        if(intervalSettingsValues.isMajor7th()) { btMajor7th.setEnabled(true);} else {btMajor7th.setEnabled(false);}
        if(intervalSettingsValues.isOctave()) { btOctave.setEnabled(true);} else {btOctave.setEnabled(false);}
    }
}