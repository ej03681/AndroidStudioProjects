package edu.georgiasouthern.project01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int startN = 0;
    int nextN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView fibOut = (TextView) findViewById(R.id.fibonacciOut);

        Button nextFib = (Button) findViewById(R.id.nextFib);
        nextFib.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                fibOut.setText(fibonacciRecursion(startN));
                startN++;
            }
        });

        Button reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startN = 0;
                fibOut.setText(startN + " ");
            }
        });
    }

    public static int fibonacciRecursion(int n){
        if (n == 0){
            return 0;
        }
        if (n == 1 || n == 2){
            return 1;
        }
        return fibonacciRecursion( n - 2 ) + fibonacciRecursion( n - 1 );
    }
}