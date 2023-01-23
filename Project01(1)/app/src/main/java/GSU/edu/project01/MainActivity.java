package GSU.edu.project01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {
    int startN = 0;

    BigInteger f(int n) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        BigInteger c = BigInteger.ONE;
        for (int i = 2; i < n; i++) {
            c = a.add(b);
            a = b;
            b = c;
        }
        return c;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button nextFib = findViewById(R.id.nextFib);


        nextFib.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                TextView fibOut = (TextView) findViewById(R.id.fibonacciOut);
                fibOut.setText(f(startN) + " ");
                startN++;
            }
        });

        Button reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startN = 0;
                TextView fibOut = (TextView) findViewById(R.id.fibonacciOut);
                fibOut.setText(f(startN) + " ");
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