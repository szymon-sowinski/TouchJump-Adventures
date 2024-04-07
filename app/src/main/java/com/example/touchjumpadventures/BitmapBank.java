package com.example.touchjumpadventures;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapBank {

    Bitmap background;
    Bitmap[] stone;
    Bitmap[] square;

    public BitmapBank(Resources res) {
        background = BitmapFactory.decodeResource(res, R.drawable.background);
        background = scaleImage(background);
        square = new Bitmap[1];
        square[0] = BitmapFactory.decodeResource(res, R.drawable.square);
        stone = new Bitmap[1];
        stone[0] = BitmapFactory.decodeResource(res, R.drawable.stone);

    }

    public Bitmap getSquare(int frame) {
        return square[frame = 0];
    }

    public int getSquareWidth() {
        return square[0].getWidth();
    }

    public int getSquareHeight() {
        return square[0].getHeight();
    }

    public Bitmap getBackground() {
        return background;
    }

    public int getBackgroundWidth() {
        return background.getWidth();
    }

    public int getBackgroundHeight() {
        return background.getHeight();
    }

    public Bitmap scaleImage(Bitmap bitmap) {
        float widthHeightRatio = getBackgroundWidth() / getBackgroundHeight();
        int backgroundScaledWidth = (int) widthHeightRatio * AppConstants.SCREEN_HEIGHT;
        return Bitmap.createScaledBitmap(bitmap, backgroundScaledWidth, AppConstants.SCREEN_HEIGHT, false);
    }

    public Bitmap getStone(int frame) {
        return stone[frame = 0];
    }

    public int getStoneWidth() {
        return stone[0].getWidth();
    }

    public int getStoneHeight() {
        return stone[0].getHeight();
    }
}
