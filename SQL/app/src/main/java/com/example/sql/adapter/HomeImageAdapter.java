package com.example.sql.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sql.R;
import com.example.sql.model.Home;

import java.util.ArrayList;


public class HomeImageAdapter extends RecyclerView.Adapter<HomeImageAdapter.HomeImageViewHolder> {

    Context context;
    ArrayList<Home> homes;


    public HomeImageAdapter(Context context, ArrayList<Home> homes) {
        this.context = context;
        this.homes = homes;
    }


    @NonNull
    @Override
    public HomeImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.item_home, parent, false);
        return new HomeImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeImageViewHolder holder, int position) {
        Glide.with(context).load(homes.get(position).url_image).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return homes.size();
    }



    public class HomeImageViewHolder extends RecyclerView.ViewHolder {
        ImageView image;

        public HomeImageViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
        }
    }
}
