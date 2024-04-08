package com.example.touchjumpadventures;

import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceHolder;


public class GameThread extends Thread {
    SurfaceHolder surfaceHolder;
    public static boolean isPies = true;
    boolean isRunning;
    long startTime, loopTime;
    long DELAY = 20;
    public GameThread(SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
        isRunning = true;
    }
    @Override
    public void run() {
        while (isRunning) {
            startTime = SystemClock.uptimeMillis();
            Canvas canvas = surfaceHolder.lockCanvas(null);
            if (canvas != null) {
                synchronized (surfaceHolder) {
                    AppConstants.getGameEngine().updateAndDrawBackgroundImage(canvas);
                    AppConstants.getGameEngine().updateAndDrawSquare(canvas);
                    AppConstants.getGameEngine().updateAndDrawStoneObstacle(canvas);

                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
            loopTime = SystemClock.uptimeMillis() - startTime;
            if (loopTime < DELAY) {
                try {
                    Thread.sleep(DELAY - loopTime);
                } catch (InterruptedException e) {
                    Log.d("Interrupted", "Interrupted while sleeping");
                }
            }

            if (AppConstants.getGameEngine().gameState == 1 && isPies) {
                AppConstants.getGameEngine().generateObstacles();
                isPies = false;
            }
        }
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean state) {
        isRunning = state;
    }
}
