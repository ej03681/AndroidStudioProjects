package edu.georgiasouthern.threadingpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = findViewById(R.id.imageView2);

        Button scale = (Button) findViewById(R.id.button);
        scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImgTask task = new ImgTask();
                task.execute();

            }
        });
    }
        public class ImgTask extends AsyncTask<Void, Void, Bitmap>{
            @Override
            protected Bitmap doInBackground(Void... voids){
                Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.roman);
                int w = bm.getWidth();
                int h = bm.getHeight();
                int[][] a = new int[w][h];
                Bitmap bm2 = bm.copy(Bitmap.Config.ARGB_8888, true);
                for(int i = 0; i < w; i++){
                    for(int j = 0; j < h; j++){
                        int c = bm.getPixel(i, j);
                        int b = c & 0xff;
                        int g = (c >> 8) & 0xff;
                        int r = (c >> 16) & 0xff;
                        a[i][j] = (r + g + b) / 3;
                        int color = 0xff000000;
                        color |= (a[i][j] << 16) | (a[i][j]<<8) | (a[i][j]);
                        bm2.setPixel(i, j, a[i][j]);
                    }
                }
                return bm2;
            }
            protected void onPostExecute(Bitmap result){
                super.onPostExecute(result);
                iv.setImageBitmap(result);
            }
        }

}