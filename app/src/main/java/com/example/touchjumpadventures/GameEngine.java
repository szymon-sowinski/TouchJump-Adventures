package com.example.touchjumpadventures;

import android.graphics.Canvas;

public class GameEngine {
    BackgroundImage backgroundImage;
    Square square;
    static int gameState;
    public GameEngine() {
        backgroundImage = new BackgroundImage();
        square = new Square();
        gameState = 0;
    }
    public void updateAndDrawBackgroundImage(Canvas canvas) {

        backgroundImage.setX(backgroundImage.getX() - backgroundImage.getVelocity());
        if(backgroundImage.getX() < -AppConstans.getBitmapBank().getBackgroundWidth()){
            backgroundImage.setX(0);
        }
        canvas.drawBitmap(AppConstans.getBitmapBank().getBackground(), backgroundImage.getX(), backgroundImage.getY(), null);
        if(backgroundImage.getX() < -(AppConstans.getBitmapbank().getBackgroundWidth() - AppConstans.SCREEN_WIDTH)) {
            canvas.drawBitmap(AppConstans.getBitmapbank().getBackground(), backgroundImage.getX() +
                    AppConstans.getBitmapbank().getBackgroundWidth(), backgroundImage.getY(), null);
        }
    }

    public void updateAndDrawSquare(Canvas canvas) {
        if(gameState == 1) {
        if(square.getY() < (AppConstans.SCREEN_HEIGHT - AppConstans.getBitmapBank().getSquareHeight()) || square.getVelocity() < 0) {
            square.setVelocity(square.getVelocity() + AppConstans.gravity);
            square.setY(square.getY() + square.getVelocity());
        }
        }
        int currentFrame = square.getCurrentFrame();
        canvas.drawBitmap (AppConstans.getBitmapbank().getSquare(currentFrame), square.getX(), square.getY(),  null);
        currentFrame++;
        if(currentFrame > square.maxFrame) {
         currentFrame = 0;
        }
        square.setCurrentFrame(currentFrame);
    }
}
