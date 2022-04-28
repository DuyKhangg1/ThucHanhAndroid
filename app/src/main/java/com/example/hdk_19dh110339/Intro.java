package com.example.hdk_19dh110339;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Intro extends AppCompatActivity {
    private static int SPLASH_SCREEN = 3000;
    Animation topAnim,bottomAnim;
    TextView tvLogo_Intro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_anim);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);
        tvLogo_Intro = findViewById(R.id.tvLogo_Intro);

        tvLogo_Intro.setAnimation(topAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Intro.this,SignIn.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}