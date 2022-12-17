package com.example.hungrygone.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.hungrygone.Adapter.RestaurantListAdpter;
import com.example.hungrygone.Adapter.RestaurantListAdpter1;
import com.example.hungrygone.Adapter.RestaurantListAdpter2;
import com.example.hungrygone.HelperClass.Commonfunctions;
import com.example.hungrygone.Model.RestaurantListModel;
import com.example.hungrygone.R;
import com.example.hungrygone.databinding.ActivityHomeBinding;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    private ActivityHomeBinding binding;
    private ArrayList<SlideModel> list = new ArrayList<>();
    private ArrayList<SlideModel> list1 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Commonfunctions.LoadPreferences(Home.this);
        Commonfunctions.SavePreferences("Logged","Logged",Home.this);
        Commonfunctions.LoadPreferences(Home.this);
        getSupportActionBar().hide();
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();
        setContentView(root);

        list.add(new SlideModel(R.drawable.res1,"Awesome foods",ScaleTypes.FIT));
        list.add(new SlideModel(R.drawable.res2, "Enjoying Foods",ScaleTypes.FIT));
        list.add(new SlideModel(R.drawable.res3, "Great Foods",ScaleTypes.FIT));
        list.add(new SlideModel(R.drawable.res4, "Amazing Foods",ScaleTypes.FIT));

        list1.add(new SlideModel(R.drawable.rest1,"Restaurant1",ScaleTypes.FIT));
        list1.add(new SlideModel(R.drawable.rest2, "Restaurant2",ScaleTypes.FIT));
        list1.add(new SlideModel(R.drawable.rest3, "Restaurant3",ScaleTypes.FIT));
        list1.add(new SlideModel(R.drawable.res4, "Restaurant4",ScaleTypes.FIT));

        binding.imageSlider.setImageList(list);
       // binding.imageSlider1.setImageList(list1);
        setRestaurantList();
    }

    private void setRestaurantList() {
        ArrayList<RestaurantListModel> restaurantListModels = new ArrayList<>();
        restaurantListModels.add(new RestaurantListModel(R.drawable.rest1,"Restaurant 1"));
        restaurantListModels.add(new RestaurantListModel(R.drawable.rest2,"Restaurant 2"));
        restaurantListModels.add(new RestaurantListModel(R.drawable.rest3,"Restaurant 3"));
        restaurantListModels.add(new RestaurantListModel(R.drawable.rest4,"Restaurant 4"));
        binding.restaurantListRv.setLayoutManager(new LinearLayoutManager(Home.this, LinearLayoutManager.HORIZONTAL, false));
        RestaurantListAdpter restaurantListAdpter = new RestaurantListAdpter(Home.this, restaurantListModels);
        binding.restaurantListRv.setAdapter(restaurantListAdpter);
        restaurantListAdpter.notifyDataSetChanged();


        ArrayList<RestaurantListModel> restaurantListModels1 = new ArrayList<>();
        restaurantListModels1.add(new RestaurantListModel(R.drawable.dosai,"Dosai"));
        restaurantListModels1.add(new RestaurantListModel(R.drawable.briyani,"Briyani"));
        restaurantListModels1.add(new RestaurantListModel(R.drawable.parota,"Parota"));
        restaurantListModels1.add(new RestaurantListModel(R.drawable.idli,"Idli"));
        binding.restaurantListRv1.setLayoutManager(new LinearLayoutManager(Home.this, LinearLayoutManager.VERTICAL, false));
        RestaurantListAdpter1 restaurantListAdpter1 = new RestaurantListAdpter1(Home.this, restaurantListModels1);
        binding.restaurantListRv1.setAdapter(restaurantListAdpter1);
        restaurantListAdpter1.notifyDataSetChanged();

        ArrayList<RestaurantListModel> restaurantListModels2 = new ArrayList<>();
        restaurantListModels2.add(new RestaurantListModel(R.drawable.foods1,"Recipes 1"));
        restaurantListModels2.add(new RestaurantListModel(R.drawable.foods2,"Recipes 2"));
        restaurantListModels2.add(new RestaurantListModel(R.drawable.foods3,"Recipes 3"));
        restaurantListModels2.add(new RestaurantListModel(R.drawable.foods4,"Recipes 4"));
        binding.restaurantListRv2.setLayoutManager(new LinearLayoutManager(Home.this, LinearLayoutManager.HORIZONTAL, false));
        RestaurantListAdpter2 restaurantListAdpter2 = new RestaurantListAdpter2(Home.this, restaurantListModels2);
        binding.restaurantListRv2.setAdapter(restaurantListAdpter2);
        restaurantListAdpter1.notifyDataSetChanged();

    }
}