package edu.georgiasouthern.nettime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.DataInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {
        EditText et = findViewById(R.id.editText);
        String address = et.getText().toString();
        new NetTask().execute(address);

    }
    public class NetTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            String result = "";
            String address = strings[0];
            try {
                Socket socket = new Socket();
                InetSocketAddress socketAddress = new InetSocketAddress(address, 37);
                socket.connect(socketAddress, 2000);
                DataInputStream input = new DataInputStream(socket.getInputStream());
                long t = 0xffffffffL & input.readInt();
                result = "seconds" + t;
                input.close();
            } catch (Exception ex) {
                result = ex.getMessage();
            }

            return result;
        }
    }
    protected void onPostExecute(String result) {
        TextView textView = findViewById(R.id.tv);
        textView.setText(result);
    }

}