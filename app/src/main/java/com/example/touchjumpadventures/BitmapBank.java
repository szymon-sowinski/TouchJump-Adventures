package com.example.touchjumpadventures;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapBank {

    Bitmap background;
    Bitmap[] square;
    public BitmapBank(Resources res) {
        background = BitmapFactory.decodeResource(res, R.drawable.background);
        background = scaleImage(background);
        square = new Bitmap[1];
        square[0] = BitmapFactory.decodeResource(res, R.drawable.square);
    }

    public Bitmap getSquare(int frame){
        return square[frame];
    }

    public int getSquareWidth(){
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
        int backgroundScaledWidth = (int) widthHeightRatio * AppConstans.SCREEN_HEIGHT;
        return Bitmap.createScaledBitmap(bitmap, backgroundScaledWidth, AppConstans.SCREEN_HEIGHT, false);
    }
}
