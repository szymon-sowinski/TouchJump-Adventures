package com.example.touchjumpadventures;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapBank {

    Bitmap background;
    public BitmapBank(Resources res) {
        background = BitmapFactory.decodeResource(res, R.drawable.background);
        background = scaleImage(background);
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
