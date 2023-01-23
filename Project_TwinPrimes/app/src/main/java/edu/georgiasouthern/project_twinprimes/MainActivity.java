package edu.georgiasouthern.project_twinprimes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et;
    TextView tv;
    Handler handler;
    int b;
    int c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.editText);
        tv = (TextView) findViewById(R.id.textView);
        tv.setMovementMethod(new ScrollingMovementMethod());
        handler = new Handler(Looper.getMainLooper());
    }

    static boolean isPrime(int p) {
        boolean prime = true;
        int s = (int) Math.sqrt(p);
        for(int d = 2; prime && d <= s; d++) {
            if (p % d == 0) prime = false;

        }
        return prime;
    }
    private void postTwin(String s){
        handler.post(new Runnable(){

            @Override
            public void run() {
                tv.append(s);
            }
        });
    }
    public void twinThread(View view){
        tv.setText("twins");
        b = Integer.parseInt(et.getText().toString());
        Thread thread = new Thread(new Runnable(){

            @Override
            public void run() {
                c = 0;
                for(int p = 3; p < b; p+= 2){
                    if (isPrime(p) && isPrime(p + 2)){
                        postTwin(" [" + p + "," + (p + 2) + "]");
                        c++;
                    }
                }
                postTwin(" total: " + c);
            }
        });
        thread.start();
    }
    public void twin(View view){
        int b = Integer.parseInt((et.getText().toString()));
        new TwinTask().execute(b);

    }
    class TwinTask extends AsyncTask<Integer, Integer, Integer> {
        @Override
        protected void onPreExecute(){
            tv.setText("twins:");
        }

        @Override
        protected Integer doInBackground(Integer... params) {
            int n = params[0];
            int c = 0;
            for(int p = 3; p < n; p+=2){
                publishProgress(p);
                c++;
            }
            return c;
        }
        protected void onProgressUpdate(Integer... params){
            int p = params[0];
            tv.append(" [" + p + "," + (p + 2) + "]");
        }
        protected void onPostExecute(Integer result) {
            tv.append(" total: " + result);
        }
    }
}