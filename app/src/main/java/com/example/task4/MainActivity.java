package com.example.task4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.task4.database.model.Dao;
import com.example.task4.database.model.UserDatabase;
import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {

    MaterialCardView scienceView,userProfileView;
    TextView userNameView ;
    Dao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        SharedPreferences sharedPreferences = getSharedPreferences("USER_DATA_FILE",MODE_PRIVATE);
        String userEmail = sharedPreferences.getString("USER_EMAIL","");

        dao = UserDatabase.getDatabase(MainActivity.this).dao();

        userNameView.setText("Hello "+dao.getUserData(userEmail).getUsername()+"!");

        userProfileView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ProfileActivity.class));
            }
        });

        scienceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,QuizActivity.class));
            }
        });


    }

    public  void  init(){
        userNameView = findViewById(R.id.profileName);
        userProfileView = findViewById(R.id.profileCardView);
        scienceView = findViewById(R.id.science);
    }
}