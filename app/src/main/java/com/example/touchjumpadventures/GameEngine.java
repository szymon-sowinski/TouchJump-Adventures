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

    public void updateAndDrawBackgroundImage(Canvas canvas) {
        // Przesunięcie tła w lewo na podstawie jego prędkości
        backgroundImage.setX(backgroundImage.getX() - backgroundImage.getVelocity());

        int backgroundWidth = AppConstants.getBitmapBank().getBackgroundWidth();

        // Jeśli tło przesunęło się wystarczająco daleko w lewo, aby całkowicie zniknąć z ekranu
        if (backgroundImage.getX() < -backgroundWidth) {
            // Zresetuj pozycję tła, przesuwając je za ekran, po przeciwnej stronie
            backgroundImage.setX(backgroundImage.getX() + backgroundWidth);
        }

        // Pozycja X tła na ekranie (niezależnie od przesunięcia)
        float drawX = backgroundImage.getX();

        // Rysowanie tła w sposób ciągły, aby pokryć całą szerokość ekranu
        while (drawX < AppConstants.SCREEN_WIDTH) {
            // Rysuj tło na aktualnej pozycji drawX
            canvas.drawBitmap(
                    AppConstants.getBitmapBank().getBackground(),
                    drawX,
                    backgroundImage.getY(),
                    null
            );

            // Przesuń drawX o szerokość tła, aby przygotować się do rysowania kolejnej kopii
            drawX += backgroundWidth;
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
