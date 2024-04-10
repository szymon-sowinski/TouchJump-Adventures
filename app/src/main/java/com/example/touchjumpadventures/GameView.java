package com.example.touchjumpadventures;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    GameThread gameThread;
    public GameView(Context context) {
        super(context);
        initView();
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {

        if(!gameThread.isRunning())
        {
            gameThread = new GameThread(holder);
            gameThread.start();
        }

        else
        {
            gameThread.start();
        }
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

        if(gameThread.isRunning())
        {
            gameThread.setIsRunning(false);
            boolean retry = true;

            while(retry)
            {
            try
            {
                gameThread.join();
                retry = false;
            }catch(InterruptedException e){}

            }
        }
    }

    void initView()
    {
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        setFocusable(true);
        gameThread = new GameThread(holder);
    }

    private long lastClickTime = 0;
    private static final long CLICK_DELAY = 100;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastClickTime < CLICK_DELAY) {
            return true;
        }

        int action = event.getAction();
        if (action == MotionEvent.ACTION_DOWN) {
            AppConstants.getGameEngine().gameState = 1;
            AppConstants.getGameEngine().square.setVelocity(AppConstants.jumpVelocity);
            lastClickTime = currentTime;
        }
        return true;
    }
}
