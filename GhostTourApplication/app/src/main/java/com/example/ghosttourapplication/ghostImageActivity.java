package com.example.ghosttourapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ghostImageActivity extends AppCompatActivity {

    TextView markerTxt;
    Button clicked;
    Button goBack;
    Button checker;
    TextView response;
    TextView fact;
    TextView question;
    //SurfaceView background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghost_image);
        markerTxt = findViewById(R.id.markerTitle);
        response = findViewById(R.id.editTextTextPersonName2);
        fact = findViewById(R.id.factText);
        question = findViewById(R.id.questionText);

        clicked = findViewById(R.id.button);
        clicked.setVisibility(View.INVISIBLE);

        String title = getIntent().getStringExtra("title");
        markerTxt.append(title);

        clicked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (title.equals("Child's Play")) {
                    Intent i = new Intent(ghostImageActivity.this, activity_bind_spirt2.class);
                    ghostImageActivity.this.startActivity(i);
                } else {
                    Intent i = new Intent(ghostImageActivity.this, bindSpirit.class);
                    ghostImageActivity.this.startActivity(i);
                }

            }
        });

        goBack = findViewById(R.id.button3);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        String factStr = getIntent().getStringExtra("fact");
        fact.append(factStr);

        String q = getIntent().getStringExtra("question");
        question.append(q);

        checker = findViewById(R.id.button4);
        checker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tester = getIntent().getStringExtra("answer");
                if (response.getText().toString().equals(tester)) {
                    clicked.setClickable(true);
                    clicked.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(ghostImageActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //background = (SurfaceView)findViewById(R.id.ghostView);
        //background.setZOrderOnTop(true);
        //SurfaceHolder backHolder = background.getHolder();
        //backHolder.setFormat(PixelFormat.TRANSPARENT);
    }


}