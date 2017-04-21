package com.example.sumit_thakur.concept;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.sumit_thakur.concept.BaseActivity.BaseActivity;

/**
 * Splash Screen
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        }, TIME_OUT);
    }
}
