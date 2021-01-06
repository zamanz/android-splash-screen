package com.zaman.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {
    private static final int SPLASH_SCREEN = 1500;
    Animation bottomAnim;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);


        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animition);

        textView = findViewById(R.id.title);

        //set Animation
        textView.setAnimation(bottomAnim);
        startMainActivity();

    }

    public void startMainActivity(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(SPLASH_SCREEN);
                    Intent intent = new Intent(getApplicationContext(), UserActivity.class);
                    startActivity(intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animition);
        textView = findViewById(R.id.title);
        //set Animation
        textView.setAnimation(bottomAnim);
        startMainActivity();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}