package gsu.edu.testingpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    int n = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button reset = findViewById(R.id.buttonReset);
        reset.setOnClickListener(v -> {
//           n = 1;
            TextView tv = findViewById(R.id.textView);
            EditText et = findViewById(R.id.editText);
            String str = String.valueOf(et.getText());
            n = Integer.parseInt(str);
            tv.setText(String.format("%04d", n));
        });
//        reset.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                n = 1;
//                TextView tv = findViewById(R.id.textView);
//                tv.setText("Reset: " + n);
//            }
//        });

    }

    public void buttonClick(View view) {
//        Toast.makeText(this, "You clicked the button", Toast.LENGTH_LONG).show();
        Snackbar.make(view, "Snackbar message", Snackbar.LENGTH_LONG).show();
        n += n;
        TextView tv = findViewById(R.id.textView);
        tv.setText("next number: " + n);
    }
}