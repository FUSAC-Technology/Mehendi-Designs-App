package com.capstone.mehendidesignsapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;

public class Images_Adapter extends RecyclerView.Adapter<Images_Adapter.MyViewHolder> {
    List<Drawable> img_list;
    Context context;
    String category_name;

    public Images_Adapter(List<Drawable> imgList, String category_name, RecView_List recView_list) {
        this.img_list=imgList;
        this.category_name=category_name;
        this.context=recView_list;
    }


    @NonNull
    @Override
    public Images_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Images_Adapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imageView.setImageDrawable(img_list.get(position));

        holder.imageCardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent (context, View_Design_Activity.class);
                intent.putExtra("image_position", position);
                intent.putExtra("categoryName", category_name);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return img_list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        CardView imageCardview;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageCardview=itemView.findViewById(R.id.image_cardview);
            imageView=itemView.findViewById(R.id.Item_img);
        }
    }
}