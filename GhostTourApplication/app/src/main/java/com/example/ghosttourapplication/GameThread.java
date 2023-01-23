package com.example.ghosttourapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.view.SurfaceHolder;
import android.widget.Toast;

import java.util.Random;


public class GameThread extends Thread{
    SurfaceHolder holder;
    boolean running = true;
    int x, y;
    int w, h;
    int hpLeft;
    boolean isKilled = false;

    public GameThread(SurfaceHolder holder, int w, int h) {
        this.holder = holder;
        this.w = w;
        this.h = h;
        hpLeft = w;
    }

    public void setRunning(boolean b) {
        this.running = b;
    }

    public void run() {
        Canvas canvas = null;
        Paint white = new Paint();
        white.setColor(Color.WHITE);
        Paint black = new Paint();
        black.setColor(Color.BLACK);
        black.setStyle(Paint.Style.STROKE);
        black.setStrokeWidth(15);

        Paint red = new Paint();
        red.setColor(Color.RED);


        long previousTime = System.currentTimeMillis();

        Random rand = new Random();
        float x = rand.nextInt(w);
        float y = rand.nextInt(h);

        while (running) {
            try {
                canvas = holder.lockCanvas(null);

                synchronized (canvas) {
                    /* //testing drawing a cnavas of a ghost and moving it, didnt work out well
                    long currentTime = System.currentTimeMillis();
                    double elapsedTime = currentTime - previousTime;
                    if (elapsedTime > 2000) {

                        x = rand.nextInt(w - 50) + 50;
                        y = rand.nextInt(h - 50) + 50;

                        previousTime = currentTime;
                    }*/
                    canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.MULTIPLY);
                    //canvas.drawCircle(x, y, 50, white);
                    canvas.drawRect(new RectF(5,5, hpLeft, 100 - 5), red);
                    canvas.drawRect(new RectF(0, 0, w, 100), black);
                    if (isKilled) {
                        //canvas.drawRect(new RectF(0, 0, w, h), white);
                        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
                    }
            }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            finally {
                if (canvas != null) {
                    holder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }

    public int getHpLeft() {
        return hpLeft;
    }

    public void changeHP(int value) {
        if (hpLeft >= value) {
            hpLeft -= value;
        } else {
            hpLeft = 0;
            isKilled = true;
        }

    }
}
