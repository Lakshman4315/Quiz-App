package com.example.task4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        SharedPreferences userSharedPreferences = getSharedPreferences("com.example.android.quiz_app",MODE_PRIVATE);
        Boolean LOGGEDIN = userSharedPreferences.getBoolean("loggedIn",false);
        if(LOGGEDIN){
            startActivity(new Intent(this,MainActivity.class));
            finish();
        }
        findViewById(R.id.Register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WelcomeActivity.this,RegisterActivity.class));
                finish();
            }
        });

        findViewById(R.id.Login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WelcomeActivity.this,LoginActivity.class));
                finish();
            }
        });
    }
}