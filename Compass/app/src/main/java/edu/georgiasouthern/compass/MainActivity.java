package edu.georgiasouthern.compass;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    SensorManager sm;
    Sensor sensor;
    LevelView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.levelView);
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);

        sensor = sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);


    }


    protected  void onResume() {
        super.onResume();
        sm.registerListener(this, sensor, SensorManager.SENSOR_DELAY_UI);
    }
    protected void onPause(){
        super.onPause();
        sm.unregisterListener(this);

    }
    @Override
    public void onSensorChanged(SensorEvent event) {

        double x = event.values[0];
        double y = event.values[1];
        double z = event.values[2];
        double g = Math.sqrt(x * x + y * y + z * z);
        lv.x = (float) (-x * 180 / 3.14159);
        lv.y = (float) (y * 180 / 3.14159);
        lv.invalidate();

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}