package com.example.mqtt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;

public class splashScreenActivity extends AppCompatActivity {

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handler = new Handler();

        mAuth = FirebaseAuth.getInstance();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if(mAuth.getCurrentUser() != null){

                Intent intent = new Intent(splashScreenActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

                }else {

                    Intent intent = new Intent(splashScreenActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();

                }

            }
        },3000);
    }
}