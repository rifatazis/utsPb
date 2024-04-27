package com.example.utsrifat.ui;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.utsrifat.R;
import com.example.utsrifat.data.response.Users;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private List<Users> users;
    public UserAdapter(List<Users> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_review, parent, false);
        return new UserAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Users user = users.get(position);
        holder.username.setText(user.getUsername());
        Picasso.get().load(user.getAvatarUrl()).into(holder.images);

        holder.itemView.setOnClickListener(click -> {
            Intent intent = new Intent(click.getContext(), DetailActivity.class);
            intent.putExtra("nama", user.getName());
            intent.putExtra("username", user.getUsername());
            intent.putExtra("bio", user.getBio());
            intent.putExtra("gambar", user.getAvatarUrl());
            click.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView images;
        TextView username;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            images = itemView.findViewById(R.id.image);
            username = itemView.findViewById(R.id.tvNama);
        }
    }
}
