package gsu.edu.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button rotate = (Button) findViewById(R.id.rotate);
        rotate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openSecond();
            }
        });
        Button scale = (Button) findViewById(R.id.scale);
        scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openThird();
            }
        });
    }
    public void openSecond(){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
    public void openThird(){
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }


}