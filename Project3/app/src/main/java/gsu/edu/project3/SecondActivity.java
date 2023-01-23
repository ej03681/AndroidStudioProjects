package gsu.edu.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Switch rotate = findViewById(R.id.rotateOn);
        rotate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(rotate.isChecked()){
                    startAnim();
                } else
                    stopAnim();
            }
        });

    }
    public void startAnim() {
        ImageView emblem = findViewById(R.id.imageView);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotate);
        emblem.startAnimation(anim);
    }
    public void stopAnim(){
        ImageView emblem = findViewById(R.id.imageView);
        emblem.clearAnimation();
    }
}