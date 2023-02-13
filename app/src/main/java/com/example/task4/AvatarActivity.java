package com.example.task4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AvatarActivity extends AppCompatActivity {

    private ImageView userAvatarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar);

        init();

    }

    public void init(){
        userAvatarView = findViewById(R.id.userAvatar);
    }

    public void NextListener(View view) {
        Intent intent = new Intent(AvatarActivity.this,MainActivity.class);
        startActivity(intent);
    }
}