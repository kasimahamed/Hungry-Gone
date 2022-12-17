package com.example.hungrygone.Model;

public class RestaurantListModel {
    int img;
    String name;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RestaurantListModel(int img, String name) {
        this.img = img;
        this.name = name;
    }
}
