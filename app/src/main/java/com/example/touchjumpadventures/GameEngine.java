package com.example.touchjumpadventures;

import android.graphics.Canvas;

public class GameEngine {
    BackgroundImage backgroundImage;
    Square square;
    static int gameState;
    boolean isFalling = false;
    boolean isJumping = false;
    int targetY = 650;

    public GameEngine() {
        backgroundImage = new BackgroundImage();
        square = new Square();
        gameState = 0;
    }

    public void updateAndDrawBackgroundImage(Canvas canvas) {       //Background - probably
        backgroundImage.setX(backgroundImage.getX() - backgroundImage.getVelocity());
        if(backgroundImage.getX() < -AppConstants.getBitmapBank().getBackgroundWidth()){
            backgroundImage.setX(0);
        }
        canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getX(), backgroundImage.getY(), null);
        if(backgroundImage.getX() < -(AppConstants.getBitmapBank().getBackgroundWidth() - AppConstants.SCREEN_WIDTH)) {
            canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getX() +
                    AppConstants.getBitmapBank().getBackgroundWidth(), backgroundImage.getY(), null);
        }
    }

    public void updateAndDrawSquare(Canvas canvas) {        //Jumping - probably
        if(gameState == 1) {
            if(isFalling) {
                if(square.getY() < (AppConstants.SCREEN_HEIGHT - AppConstants.getBitmapBank().getSquareHeight()) || square.getVelocity() < 0) {
                    square.setVelocity(square.getVelocity() + AppConstants.gravity);
                    square.setY(square.getY() + square.getVelocity());
                }
                if (square.getY() >= targetY) {
                    square.setY(targetY);
                    isFalling = true;
                }
                if(gameState == 1) {


                }
            }
        } else {
            isFalling = true;
        }

        int currentFrame = square.getCurrentFrame();
        canvas.drawBitmap(AppConstants.getBitmapBank().getSquare(currentFrame), square.getX(), square.getY(),  null);
        currentFrame++;
        if(currentFrame > square.maxFrame) {
            currentFrame = 0;
        }
        square.setCurrentFrame(currentFrame);
    }

    public void startGame() {
        gameState = 1;
    }
}
