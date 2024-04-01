package com.example.touchjumpadventures;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton helpButton;
    private ImageButton playButton;
    private ImageButton settingsButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helpButton = findViewById(R.id.Help);
        playButton = findViewById(R.id.Start);
        settingsButton = findViewById(R.id.Settings);
    }
    public void StartGame(View view){
        helpButton.setOnClickListener(v -> {
            Log.d("HelpButton", "clicked");
        });

        playButton.setOnClickListener(v -> {
            Log.d("PlayButton", "clicked");
        });

        settingsButton.setOnClickListener(v -> {
            Log.d("SettingsButton", "clicked");
        });
    }
}
