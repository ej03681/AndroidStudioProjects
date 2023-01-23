package com.example.ghosttourapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;

public class bindSpirit extends AppCompatActivity {

    SurfaceView background;
    ImageView house;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_spirit);
        house = findViewById(R.id.imageView3);

        background = (SurfaceView)findViewById(R.id.ghostView4);
        background.setZOrderOnTop(true);
        SurfaceHolder backHolder = background.getHolder();
        backHolder.setFormat(PixelFormat.TRANSPARENT);
    }

    public void goBack(View view) {
        finish();
    }
}