package com.example.touchjumpadventures;

import java.util.Random;

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

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public void setCurrentFrame(int currentFrame) {
        this.currentFrame = currentFrame;
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

        if (stoneX < -AppConstants.getBitmapBank().getStoneWidth()) {
//            stoneX = AppConstants.SCREEN_WIDTH;
            stoneY = generateRandomYPosition();
        }

        if (stoneX > AppConstants.SCREEN_WIDTH) {
//            stoneX = -AppConstants.getBitmapBank().getStoneWidth();
            stoneY = generateRandomYPosition();
        }
    }

    private int generateRandomYPosition() {
        return new Random().nextInt(AppConstants.SCREEN_HEIGHT - AppConstants.getBitmapBank().getStoneHeight());
    }
}
