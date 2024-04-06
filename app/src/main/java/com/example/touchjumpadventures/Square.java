package com.example.touchjumpadventures;

public class Square {


    private int squareX, squareY, currentFrame, velocity;
    public static int maxFrame;
    public Square(){
        squareX = AppConstants.SCREEN_WIDTH/2 - AppConstants.getBitmapBank().getSquareWidth()/2;
        squareY = AppConstants.SCREEN_HEIGHT/2 - AppConstants.getBitmapBank().getSquareHeight()/2;
        currentFrame = 0;
        maxFrame = 1;
        velocity = 0;
    }
    public int getVelocity() {
        return velocity;
    }
    public void setVelocity(int velocity){
        this.velocity = velocity;
    }
    public int getCurrentFrame() {
        return currentFrame;
    }

    public void setCurrentFrame(int currentFrame){
        this.currentFrame = currentFrame;
    }

    public int getX(){
        return squareX;
    }

    public int getY(){
        return squareY;
    }

    public void setX(int squareX) {
        this.squareX = squareX;
    }

    public void setY(int squareY) {
        this.squareY = squareY;
    }

}
