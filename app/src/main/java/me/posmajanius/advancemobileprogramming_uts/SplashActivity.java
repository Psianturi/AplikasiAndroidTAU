package me.posmajanius.advancemobileprogramming_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TextView tv = findViewById(R.id.text_app);
        ImageView iv = findViewById(R.id.image_app);

        Animation splashTransition = AnimationUtils.loadAnimation(this, R.anim.splash_transition);
        tv.startAnimation(splashTransition);
        iv.startAnimation(splashTransition);

        final Intent i = new Intent(this, LoginActivity.class);
        Thread timer = new Thread() {
            public void run() {
                try {
                    // Lama SplashScreen
                    sleep(1620);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }


}

