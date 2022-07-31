package com.example.ringvibratesilent;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Context context;
    Button btnRing, btnVibrate, btnSilent;
    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.context = getApplicationContext();

        // Reference to the buttons
        btnRing = findViewById(R.id.btnRing);
        btnVibrate = findViewById(R.id.btnVibrate);
        btnSilent = findViewById(R.id.btnSilent);
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        // Get Do Not Disturb permission
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        // If permission is not granted, request it
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !notificationManager.isNotificationPolicyAccessGranted()) {
            Intent intent = new Intent(android.provider.Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);
            startActivity(intent);
        }


        btnRing.setOnClickListener(v -> audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL));
        btnVibrate.setOnClickListener(v -> audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE));
        btnSilent.setOnClickListener(v -> audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT));
    }
}