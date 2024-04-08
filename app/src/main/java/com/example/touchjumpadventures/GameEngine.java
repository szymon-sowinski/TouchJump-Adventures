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

        int obstacleSpacing = AppConstants.SCREEN_WIDTH / numObstacles;

        StoneObstacle obstacle = new StoneObstacle();
        obstacle.setX(AppConstants.SCREEN_WIDTH);
        obstacles.add(obstacle);

//        for (int i = 0; i < numObstacles; i++) {
//
//        }
    }
   public void startGame() {
      gameState = 1;
  }
}
