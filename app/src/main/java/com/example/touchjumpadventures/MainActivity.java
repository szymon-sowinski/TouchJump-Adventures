package com.example.touchjumpadventures;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppConstants.initialization(this.getApplicationContext());
        context = this;
    }

    public void StartGame(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
        finish();
    }
}
