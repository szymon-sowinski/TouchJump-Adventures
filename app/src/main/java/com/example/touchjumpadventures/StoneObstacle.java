package com.example.touchjumpadventures;

public class StoneObstacle {
    private int stoneX, stoneY, currentFrame, velocity;
    public static int maxFrame;

    public StoneObstacle(){
        stoneX = 0;
        stoneY = AppConstants.SCREEN_HEIGHT / 2 - AppConstants.getBitmapBank().getSquareHeight() / 2;
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
        return stoneX;
    }

    public int getY(){
        return stoneY;
    }

    public void setX(int squareX) {
        this.stoneX = stoneX;
    }

    public void setY(int squareY) {
        this.stoneY = stoneY;
    }
}
