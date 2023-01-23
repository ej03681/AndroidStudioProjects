package gsu.edu.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Switch scale = findViewById(R.id.scaleOn);
        scale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(scale.isChecked()){
                    startAnim(scale);
                } else {
                    stopAnim();
                }
            }
        });

    }

    boolean isOn;
    public void startAnim(View view){
        isOn = true;
        runAnim();
    }
    public void runAnim() {
        ImageView map = findViewById(R.id.imageView2);
        if(isOn) {
            Animation anim = AnimationUtils.loadAnimation(this, R.anim.scale);
            anim.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    runAnim();
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            map.startAnimation(anim);
        } else {
            map.clearAnimation();
        }
    }
    public void stopAnim(){
        // ImageView map = findViewById(R.id.imageView2);
        // map.clearAnimation();
        isOn = false;
        runAnim();
    }
}