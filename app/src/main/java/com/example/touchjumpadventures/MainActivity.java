package com.example.touchjumpadventures;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton helpButton;
    private ImageButton playButton;
    private ImageButton settingsButton;
    public static Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        helpButton = findViewById(R.id.Help);
        playButton = findViewById(R.id.Start);
        settingsButton = findViewById(R.id.Settings);
        AppConstants.initialization(this.getApplicationContext());
        context = this;
    }

    public void StartGame(View view) {
        Log.d("PlayButton", "clicked");

        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
        finish();
    }
}
