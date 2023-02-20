package com.example.task4;

import static com.example.task4.R.drawable.images;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task4.model.avatarModel;

import java.util.ArrayList;

public class AvatarRecyclerViewAdapter extends RecyclerView.Adapter<AvatarRecyclerViewAdapter.ViewHolder> {

    private final ArrayList<avatarModel> AvatarArray;


    AvatarRecyclerViewAdapter(ArrayList<avatarModel> avatarArray){
        AvatarArray = avatarArray;
    }

    @NonNull
    @Override
    public AvatarRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.avatar_recycler_view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AvatarRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(AvatarArray.get(position).getImageUrl());
    }

    @Override
    public int getItemCount() {
        return AvatarArray.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.recylerViewItemAvatar);
            imageView.setOnClickListener(view -> {
                ImageView imageView1 = new AvatarActivity().findViewById(R.id.userAvatar);
                imageView1.setImageResource(Integer.parseInt(imageView.getResources().toString()));
            });

        }

    }
}
