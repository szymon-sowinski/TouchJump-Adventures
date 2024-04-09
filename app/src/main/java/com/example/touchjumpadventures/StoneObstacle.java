package com.example.touchjumpadventures;


public class StoneObstacle {
    private int stoneX, stoneY, currentFrame, velocity;
    public static int maxFrame;

    public StoneObstacle() {
        stoneX = 150;
        stoneY = AppConstants.SCREEN_HEIGHT / 2 - AppConstants.getBitmapBank().getSquareHeight() / 4 + 250;
        currentFrame = 0;
        maxFrame = 1;
        velocity = 0;
    }
    public int getX() {
        return stoneX;
    }

    public int getY() {
        return stoneY;
    }

    public void setX(int stoneX) {
        this.stoneX = stoneX;
    }

    public void setY(int stoneY) {
        this.stoneY = stoneY;
    }

    public void update() {
        stoneX += -70;
    }
}
