package com.example.ghosttourapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.inline.InlineContentView;

import androidx.annotation.NonNull;

public class GhostView extends SurfaceView implements SurfaceHolder.Callback{
    GameThread thread;

    public GhostView(Context context) {
        super(context);
    }

    public GhostView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        getHolder().addCallback(this);
    }

    public GhostView(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        float x = ev.getX();
        float y = ev.getY();
        int rand =  ((int)(Math.random() * 25) + 1);
        thread.changeHP(rand);
        //Toast.makeText(this.getContext(), "Hit!", Toast.LENGTH_SHORT).show();
        if (thread.getHpLeft() == 0) {
            Toast.makeText(this.getContext(), "Success!", Toast.LENGTH_SHORT).show();

        }

        return true;

    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = new GameThread(holder, this.getWidth(), this.getHeight());
        thread.start();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        thread.setRunning(false);
        boolean retry = true;
        while (retry) {
            try {
                thread.join();
                retry = false;
            } catch (InterruptedException ex) {}
        }
    }
}
