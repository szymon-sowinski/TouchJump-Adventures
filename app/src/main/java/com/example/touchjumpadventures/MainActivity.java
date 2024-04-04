package com.example.touchjumpadventures;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        AppConstans.initialization(this.getApplicationContext());
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

        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
        finish();
    }
}
