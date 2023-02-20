package com.example.task4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.task4.model.avatarModel;

import java.util.ArrayList;

public class AvatarActivity extends AppCompatActivity {

    private ImageView userAvatarView;
    private RecyclerView recyclerView;
    private AvatarRecyclerViewAdapter avatarRecyclerViewAdapter;

    private ArrayList<avatarModel> AvatarArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar);

        init();
        AvatarArray = new ArrayList<>();

        avatarRecyclerViewAdapter = new AvatarRecyclerViewAdapter(AvatarArray);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setAdapter(avatarRecyclerViewAdapter);

        initialiseAvatar();

    }

    private void initialiseAvatar() {

        AvatarArray.clear();

        AvatarArray.add(new avatarModel(R.drawable.lion));
        AvatarArray.add(new avatarModel(R.drawable.bear));
        AvatarArray.add(new avatarModel(R.drawable.cat));
        AvatarArray.add(new avatarModel(R.drawable.dog));
        AvatarArray.add(new avatarModel(R.drawable.dog__1_));
        AvatarArray.add(new avatarModel(R.drawable.fox));
        AvatarArray.add(new avatarModel(R.drawable.meerkat));
        AvatarArray.add(new avatarModel(R.drawable.panda));
        AvatarArray.add(new avatarModel(R.drawable.wolf));
        AvatarArray.add(new avatarModel(R.drawable.rabbit));

        avatarRecyclerViewAdapter.notifyDataSetChanged();
    }

    public void init(){
        userAvatarView = findViewById(R.id.userAvatar);
        recyclerView = findViewById(R.id.recyclerViewAvatar);
    }

    public void NextListener(View view) {
        Intent intent = new Intent(AvatarActivity.this,MainActivity.class);
        startActivity(intent);
    }
}