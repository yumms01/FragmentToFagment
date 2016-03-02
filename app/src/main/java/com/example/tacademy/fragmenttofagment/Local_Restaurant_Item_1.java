package com.example.tacademy.fragmenttofagment;

import android.graphics.drawable.Drawable;

/**
 * Created by Tacademy on 2016-02-23.
 */
public class Local_Restaurant_Item_1 {
    private Drawable icon;
    private String name;

    public Local_Restaurant_Item_1(Drawable icon, String name) {
        this.icon = icon;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public Drawable getIcon() {
        return icon;
    }
}
