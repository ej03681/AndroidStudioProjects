package gsu.edu.project02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
    int tempI;
    int tempJ;
    int tempB1;
    int tempB2;

    public boolean isNear(int n){
        boolean isNear;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++) {
                if (matrix[i][j] == n) {
                    tempI = i;
                    tempJ = j;
                }
                if(matrix[i][j] == 0){
                    tempB1 = i;
                    tempB2 = j;
                    }
                }
            }
        if(Math.abs((tempI + tempJ) - (tempB1 + tempB2)) != 1) {
            return isNear = false;
        } else
            return isNear = true;
    }
    public void changeMatrix(int n){
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == n) {
                    matrix[i][j] = 0;
                }
                if (matrix[i][j] == 0) {
                    matrix[i][j] = n;
                }
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button one = findViewById(R.id.one);
        Button blank = findViewById(R.id.blank);
        one.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(isNear(Integer.parseInt(String.valueOf(one.getText())))){
                    changeMatrix(Integer.parseInt(String.valueOf(one.getText())));
                    blank.setText(one.getText());
                    one.setText("");
                }
            }
        });

        Button two = findViewById(R.id.two);
        two.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(isNear(Integer.parseInt(String.valueOf(two.getText())))) {
                    changeMatrix(Integer.parseInt(String.valueOf(two.getText())));
                    blank.setText(two.getText());
                    two.setText("");
                }
            }
        });

        Button three = findViewById(R.id.three);
        three.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(isNear(Integer.parseInt(String.valueOf(three.getText())))) {
                    changeMatrix(Integer.parseInt(String.valueOf(three.getText())));
                    blank.setText(three.getText());
                    three.setText("");
                }
            }
        });

        Button four = findViewById(R.id.four);
        four.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(isNear(Integer.parseInt(String.valueOf(four.getText())))) {
                    changeMatrix(Integer.parseInt(String.valueOf(four.getText())));
                    blank.setText(four.getText());
                    four.setText("");
                }
            }
        });

        Button five = findViewById(R.id.five);
        three.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(isNear(Integer.parseInt(String.valueOf(five.getText())))) {
                    changeMatrix(Integer.parseInt(String.valueOf(five.getText())));
                    blank.setText(five.getText());
                    five.setText("");
                }
            }
        });

        Button six = findViewById(R.id.six);
        six.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(isNear(Integer.parseInt(String.valueOf(six.getText())))) {
                    changeMatrix(Integer.parseInt(String.valueOf(six.getText())));
                    blank.setText(six.getText());
                    six.setText("");
                }
            }
        });

        Button seven = findViewById(R.id.seven);
        seven.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(isNear(Integer.parseInt(String.valueOf(seven.getText())))) {
                    changeMatrix(Integer.parseInt(String.valueOf(seven.getText())));
                    blank.setText(seven.getText());
                    seven.setText("");
                }
            }
        });

        Button eight = findViewById(R.id.eight);
        eight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(isNear(Integer.parseInt(String.valueOf(eight.getText())))) {
                    changeMatrix(Integer.parseInt(String.valueOf(eight.getText())));
                    blank.setText(eight.getText());
                    eight.setText("");
                }
            }
        });

    }
}