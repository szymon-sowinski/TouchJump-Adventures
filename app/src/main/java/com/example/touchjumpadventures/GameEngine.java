package com.example.touchjumpadventures;

import android.graphics.Canvas;

public class GameEngine {
    BackgroundImage backgroundImage;
    public GameEngine() {
        backgroundImage = new BackgroundImage();
    }
    public void updateAndDrawBackgroundImage(Canvas canvas) {
        backgroundImage.setX(backgroundImage.getX() - backgroundImage.getVelocity());
        if(backgroundImage.getX() < -AppConstans.getBitmapBank().getBackgroundWidth()){
            backgroundImage.setX(0);
        }
        canvas.drawBitmap(AppConstans.getBitmapBank().getBackground(), backgroundImage.getX(), backgroundImage.getY(), null);
    }
}
