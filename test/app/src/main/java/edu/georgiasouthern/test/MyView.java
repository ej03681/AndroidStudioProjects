package edu.georgiasouthern.test;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View{

        float x = 300;
        float y = 500;

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
            Paint blue = new Paint();
            Paint white = new Paint();

            blue.setColor(Color.BLUE);
            white.setColor(Color.WHITE);

            canvas.drawRect(100, 100, 100, 100, blue);
            canvas.drawCircle(x + 50 ,y - 50, 50, blue);
            canvas.drawCircle(x + 50, y + 50, 50, blue);
            canvas.drawCircle(x - 50, y - 50, 50, blue);
            canvas.drawCircle(x - 50, y + 50, 50, blue);
        }

}
