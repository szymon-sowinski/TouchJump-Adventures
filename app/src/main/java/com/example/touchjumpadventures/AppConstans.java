package com.example.touchjumpadventures;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class AppConstans {
    static BitmapBank bitmapbank;
    static GameEngine gameEngine;
    static int SCREEN_WIDTH, SCREEN_HEIGHT;

    public static void initialization(Context context) {
        setScreenSize(context);
        bitmapbank = new BitmapBank(context.getResources());
        gameEngine = new GameEngine();
    }

    public static BitmapBank getBitmapbank() {
        return bitmapbank;
    }

    public static GameEngine getGameEngine() {
        return gameEngine;
    }

    private static void setScreenSize(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        AppConstans.SCREEN_WIDTH = width;
        AppConstans.SCREEN_HEIGHT = height;
    }
}
