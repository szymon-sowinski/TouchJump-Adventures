package com.example.touchjumpadventures;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class AppConstants {
    static BitmapBank bitmapbank;
    static GameEngine gameEngine;
    static int SCREEN_WIDTH, SCREEN_HEIGHT;
    static int gravity;
    static int  jumpVelocity;
    public static GameActivity activity;

    public static void setActivity(GameActivity activity) {
        AppConstants.activity = activity;
    }
    public static void initialization(Context context) {
        setScreenSize(context);
        bitmapbank = new BitmapBank(context.getResources());
        gameEngine = new GameEngine(AppConstants.activity);
        AppConstants.gravity = 3;
        AppConstants.jumpVelocity = -40;
    }

    public static BitmapBank getBitmapBank() {
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
        AppConstants.SCREEN_WIDTH = width;
        AppConstants.SCREEN_HEIGHT = height;
    }
}
