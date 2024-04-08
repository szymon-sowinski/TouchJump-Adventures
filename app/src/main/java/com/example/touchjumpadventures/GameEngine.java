package com.example.touchjumpadventures;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class GameEngine {
    BackgroundImage backgroundImage;
    StoneObstacle stone;
    Square square;
    ArrayList<StoneObstacle> obstacles;
    static int gameState;
    boolean isFalling = false;
    boolean isJumping = false;
    int targetY = 650;

    public GameEngine() {
        backgroundImage = new BackgroundImage();
        square = new Square();
        stone = new StoneObstacle();
        obstacles = new ArrayList<>();
        gameState = 0;
    }

    public void updateAndDrawBackgroundImage(Canvas canvas) {
        backgroundImage.setX(backgroundImage.getX() - backgroundImage.getVelocity());

        int backgroundWidth = AppConstants.getBitmapBank().getBackgroundWidth();

        if (backgroundImage.getX() < -backgroundWidth) {
            backgroundImage.setX(backgroundImage.getX() + backgroundWidth);
        }

        float drawX = backgroundImage.getX();

        while (drawX < AppConstants.SCREEN_WIDTH) {
            canvas.drawBitmap(
                    AppConstants.getBitmapBank().getBackground(),
                    drawX,
                    backgroundImage.getY(),
                    null
            );

            drawX += backgroundWidth;
        }
    }

    public void updateAndDrawSquare(Canvas canvas) {
        if (gameState == 1) {
            int bottomEdge = AppConstants.SCREEN_HEIGHT - AppConstants.getBitmapBank().getSquareHeight();
            int newBottomPosition = bottomEdge - 220;

            if (square.getY() < 0) {
                square.setY(0);
                square.setVelocity(0);
            } else if (square.getY() > newBottomPosition) {
                square.setY(newBottomPosition);
                square.setVelocity(0);
            } else {
                square.setVelocity(square.getVelocity() + AppConstants.gravity);
                square.setY(square.getY() + square.getVelocity());
            }
        } else {
            isFalling = true;
        }

        int currentFrame = square.getCurrentFrame();
        canvas.drawBitmap(AppConstants.getBitmapBank().getSquare(currentFrame), square.getX(), square.getY(), null);
        currentFrame++;
        if (currentFrame > square.maxFrame) {
            currentFrame = 0;
        }
        square.setCurrentFrame(currentFrame);
    }

    public void updateAndDrawStoneObstacle(Canvas canvas) {
        Iterator<StoneObstacle> iterator = obstacles.iterator();
        while (iterator.hasNext()) {
            StoneObstacle obstacle = iterator.next();

            int backgroundWidth = AppConstants.getBitmapBank().getBackgroundWidth();

            if (obstacle.getX() < -backgroundWidth) {
                iterator.remove();
                continue;
            }

            float drawX = obstacle.getX();

            canvas.drawBitmap(
                    AppConstants.getBitmapBank().getStone(0),
                    drawX,
                    obstacle.getY(),
                    null
            );

            obstacle.update();
        }
    }

    public void generateObstacles() {
        int numObstacles = new Random().nextInt(3) + 1;
        int obstacleSpacing = 1200;


        int minY = 0;
        int maxY = AppConstants.SCREEN_HEIGHT / 2;

        for (int i = 0; i < 100; i++) {
            StoneObstacle obstacle = new StoneObstacle();

            int randomY = new Random().nextInt(maxY - minY + 1) + minY;

            obstacle.setX(AppConstants.SCREEN_WIDTH + i * obstacleSpacing);
            obstacle.setY(randomY);
            obstacles.add(obstacle);
        }
    }


    public void startGame() {
        gameState = 1;
    }
}
