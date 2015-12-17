package com.example.sanajavid1.coursework;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends Activity {

    //Causes the splash screen to last 4 seconds
    public static int timer = 4000;

    //onCreate starts the "splash_screen.xml" which displays the ImageView
    //MediapPlayer takes the sound clip from the raw folder
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        MediaPlayer start = MediaPlayer.create(getApplicationContext(), R.raw.splash);
        start.start();

        //The MainActivity is called after the SplashScreen finishes
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, timer);
    }
}