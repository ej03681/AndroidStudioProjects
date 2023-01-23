package edu.georgiasouthern.compass;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.RequiresApi;

public class LevelView extends View {
    float x = -50;
    float y = 100;

    public LevelView(Context context) {
        super(context);
    }

    public LevelView(Context context, AttributeSet attr){
        super(context, attr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        int w = getWidth();
        int h = getHeight();
        int cx = w/2;
        int cy = h/2;
        int r = 20;
        Paint paint = new Paint();
        paint.setARGB(255, 255, 255, 255);
        canvas.drawRect(0, 0, w, h, paint);
        float sx = cx + x;
        float sy = cy + y;
        if (sx < r) sx = r;
        if (sx > w - r) sx = w - r;
        if (sy < r) sy = r;
        if(sy > h - r) sy = h - r;

        paint.setARGB(255, 255, 0, 0);

        Path path = new Path();
        path.moveTo(sx - 20, sy);
        path.lineTo(sx, sy - 100);
        path.lineTo(sx + 20, sy);
        path.lineTo(sx - 20, sy);
        path.close();

        canvas.drawPath(path, paint);

        canvas.drawCircle(sx, sy, r, paint);

        paint.setARGB(255, 0, 0, 0);

        canvas.drawCircle(cx, cy, r + 1, paint);

    }
}