package com.example.tacademy.fragmenttofagment;

import android.graphics.drawable.Drawable;

/**
 * Created by Tacademy on 2016-02-24.
 */
public class InLocal_Restaurant_Item_2 {

    private Drawable icon;
    private String restaurant_name;
    private String location;
    private String menu;

    public InLocal_Restaurant_Item_2(Drawable icon, String restaurant_name, String location, String menu) {
        this.icon = icon;
        this.restaurant_name = restaurant_name;
        this.location = location;
        this.menu = menu;
    }

    public Drawable getIcon() {
        return icon;
    }

    public String getText_restaurant_name() {
        return restaurant_name;
    }

    public String getText_location() {
        return location;
    }

    public String getText_menu() {
        return menu;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public void setText_restaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public void setText_location(String location) {
        this.location = location;
    }

    public void setText_menu(String menu) {
        this.menu = menu;
    }
}
