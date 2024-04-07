package com.example.touchjumpadventures;

import android.graphics.Canvas;
import java.util.ArrayList;
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
        // Pobierz szerokość tła
        int backgroundWidth = AppConstants.getBitmapBank().getBackgroundWidth();

        // Przechowuje pozycję X dla następnej przeszkody
        int nextObstacleX = AppConstants.SCREEN_WIDTH;

        // Lista do przechowywania przeszkód do usunięcia
        List<StoneObstacle> obstaclesToRemove = new ArrayList<>();

        // Przesuń każdą przeszkodę wraz z tłem
        for (StoneObstacle obstacle : obstacles) {
            // Oblicz nową pozycję przeszkody
            int newX = (int) (obstacle.getX() - backgroundImage.getVelocity());

            // Ustaw nową pozycję przeszkody
            obstacle.setX(newX);

            // Sprawdź czy przeszkoda wyszła poza lewą krawędź ekranu
            if (obstacle.getX() < -backgroundWidth) {
                // Dodaj przeszkodę do listy do usunięcia
                obstaclesToRemove.add(obstacle);
            } else {
                // Rysuj przeszkodę na aktualnej pozycji
                canvas.drawBitmap(
                        AppConstants.getBitmapBank().getStone(0),
                        obstacle.getX(),
                        obstacle.getY(),
                        null
                );
            }

            // Sprawdź czy kolejna przeszkoda może zostać dodana
            if (nextObstacleX <= AppConstants.SCREEN_WIDTH) {
                // Dodaj nową przeszkodę
                StoneObstacle newObstacle = new StoneObstacle();
                newObstacle.setX(nextObstacleX);
                obstacles.add(newObstacle);

                // Zaktualizuj pozycję X dla następnej przeszkody
                nextObstacleX += 20; // Przesunięcie o 20 w osi X
            }
        }

        // Usuń przeszkody z listy do usunięcia
        obstacles.removeAll(obstaclesToRemove);
    }

    public void generateObstacles() {
        int numObstacles = new Random().nextInt(3) + 1;

        int obstacleSpacing = AppConstants.SCREEN_WIDTH / numObstacles;

        for (int i = 0; i < numObstacles; i++) {
            StoneObstacle obstacle = new StoneObstacle();
            obstacle.setX(AppConstants.SCREEN_WIDTH + i * obstacleSpacing);
            obstacles.add(obstacle);
        }
    }

    public void startGame() {
        gameState = 1;
    }
}
