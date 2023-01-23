package gsu.edu.testingpage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String msg = intent.getStringExtra("Ext");
        TextView tv = findViewById(R.id.textView3);
        tv.setText(msg);

    }

    public void buttonClick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("Ext", "from SecondActivity");
        startActivity(intent);
    }

    public void web(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://georgiasouthern.edu"));
        startActivity(intent);
    }

    public void third(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivityForResult(intent,7);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent ri) {
        super.onActivityResult(requestCode, resultCode, ri);
        if (requestCode == 7) {
            if (resultCode == RESULT_OK) {
                String msg = ri.getStringExtra("Ret");
                TextView tv = findViewById(R.id.textView3);
                tv.setText(msg);

            }
        }
    }
}