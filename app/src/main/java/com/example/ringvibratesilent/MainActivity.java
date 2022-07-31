package com.example.ringvibratesilent;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    Button btnRing, btnVibrate, btnSilent;
    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Reference to the buttons
        btnRing = findViewById(R.id.btnRing);
        btnVibrate = findViewById(R.id.btnVibrate);
        btnSilent = findViewById(R.id.btnSilent);
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);


        btnRing.setOnClickListener(v -> {
            audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
        });

        btnVibrate.setOnClickListener(v -> {
            audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
        });

        btnSilent.setOnClickListener(v -> {
            audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
        });
    }
}