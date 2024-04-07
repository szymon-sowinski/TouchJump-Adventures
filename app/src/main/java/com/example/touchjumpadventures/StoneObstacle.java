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

    // Metoda do aktualizacji pozycji przeszkody na ekranie
    public void update() {
        // Aktualizuj pozycję przeszkody na podstawie prędkości
        stoneX += velocity;

        // Jeśli przeszkoda wychodzi poza lewą krawędź ekranu, przenieś ją na prawą stronę z nową losową pozycją Y
        if (stoneX < -AppConstants.getBitmapBank().getStoneWidth()) {
            stoneX = AppConstants.SCREEN_WIDTH; // Przenieś na prawą stronę ekranu
            stoneY = generateRandomYPosition(); // Ustaw nową losową pozycję Y
        }

        // Jeśli przeszkoda wychodzi poza prawą krawędź ekranu, przenieś ją na lewą stronę z nową losową pozycją Y
        if (stoneX > AppConstants.SCREEN_WIDTH) {
            stoneX = -AppConstants.getBitmapBank().getStoneWidth(); // Przenieś na lewą stronę ekranu
            stoneY = generateRandomYPosition(); // Ustaw nową losową pozycję Y
        }
    }

    // Metoda do generowania losowej pozycji Y dla przeszkody
    private int generateRandomYPosition() {
        // Generuj losową pozycję Y w zakresie od 0 do maksymalnej wysokości ekranu
        return new Random().nextInt(AppConstants.SCREEN_HEIGHT - AppConstants.getBitmapBank().getStoneHeight());
    }
}
