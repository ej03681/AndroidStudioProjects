package edu.georgiasouthern.project09;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.jar.Attributes;

public class LevelView extends View {
    float x = -50;
    float y = 100;

    public LevelView(Context context) {
        super(context);
    }

    public LevelView(Context context, AttributeSet attr){
        super(context, attr);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        int w = getWidth();
        int h = getHeight();
        int cx = w/2;
        int cy = h/2;
        int r = 20;
        Paint paint = new Paint();
        paint.setARGB(255, 200, 235, 150);
        canvas.drawRect(0, 0, w, h, paint);
        float sx = cx + x;
        float sy = cy + y;
        if (sx < r) sx = r;
        if (sx > w - r) sx = w - r;
        if (sy < r) sy = r;
        if(sy > h - r) sy = h - r;
        
        paint.setARGB(255, 255, 255, 255);
        canvas.drawCircle(sx, sy, r, paint);
        paint.setARGB(255, 255, 0, 0);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(cx, cy, r + 1, paint);


    }


}
