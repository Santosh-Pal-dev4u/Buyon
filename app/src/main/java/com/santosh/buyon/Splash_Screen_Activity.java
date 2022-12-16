package com.santosh.buyon;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

import com.airbnb.lottie.LottieAnimationView;

public class Splash_Screen_Activity extends AppCompatActivity {

    Animation splash_screen_trans;
    LottieAnimationView shop;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        shop=findViewById(R.id.lottie_shop_splash);


        splash_screen_trans= AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                shop.setVisibility(View.VISIBLE);
                shop.setAnimation(splash_screen_trans);

            }
        },100);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splash=new Intent(Splash_Screen_Activity.this,Register_page.class);
                startActivity(splash);
                finish();
            }
        },2050);


    }
}