package com.example.hungrygone.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hungrygone.Model.RestaurantListModel;
import com.example.hungrygone.R;

import java.util.ArrayList;

public class RestaurantListAdpter2 extends RecyclerView.Adapter<RestaurantListAdpter2.MyViewHolder> {
    private final Context context;
    private final ArrayList<RestaurantListModel> restaurantModelArrayList;

    public RestaurantListAdpter2(Context context, ArrayList<RestaurantListModel> restaurantModelArrayList) {
        this.context = context;
        this.restaurantModelArrayList = restaurantModelArrayList;
    }

    @NonNull
    @Override
    public RestaurantListAdpter2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.restaurant2_model, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantListAdpter2.MyViewHolder holder, int position) {
        RestaurantListModel restaurantListModel = restaurantModelArrayList.get(position);
        holder.restaurantImg.setImageResource(restaurantListModel.getImg());
        holder.restaurantNameTv.setText(restaurantListModel.getName());

    }

    @Override
    public int getItemCount() {
        return restaurantModelArrayList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView restaurantImg;
        TextView restaurantNameTv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            restaurantImg = itemView.findViewById(R.id.restaurantIv);
            restaurantNameTv = itemView.findViewById(R.id.restaurantNameTv);

        }
    }

}
