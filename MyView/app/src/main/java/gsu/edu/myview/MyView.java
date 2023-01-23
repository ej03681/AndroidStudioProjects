package gsu.edu.myview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


public class MyView extends View {
    float cx = 400;
    float cy = 400;

    public MyView(Context context) {
        super(context);
    }
    public MyView(Context context, AttributeSet attrs){
        super(context, attrs);
    }
    public MyView(Context context, AttributeSet attrs, int def){
        super(context, attrs, def);
    }

    @SuppressLint("NewApi")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint col1 = new Paint();
        Paint col2 = new Paint();

        col1.setColor(Color.BLACK);


        col2.setColor(Color.WHITE);


        canvas.drawCircle(cx, cy, 120, col1);
        canvas.drawArc(cx - 60, cy + 60, cx + 60, cy - 0, 0, 180, false, col2);


        canvas.drawCircle(cx - 60, cy, 60, col1);

        canvas.drawCircle(cx + 60, cy, 60, col2);


        canvas.drawCircle(cx - 60, cy, 15, col2);
        canvas.drawCircle(cx + 60, cy, 15, col1);





    }
    public boolean onTouchEvent(MotionEvent motionEvent){
        cx = motionEvent.getX();
        cy = motionEvent.getY();
        this.invalidate();
        return true;
    }
}

