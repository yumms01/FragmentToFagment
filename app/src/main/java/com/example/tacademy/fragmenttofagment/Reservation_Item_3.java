package com.example.tacademy.fragmenttofagment;

import android.graphics.drawable.Drawable;

/**
 * Created by Tacademy on 2016-02-24.
 */
public class Reservation_Item_3 {
    private Drawable icon;
    private String text_name;

    public Reservation_Item_3(Drawable icon, String text_name) {
        this.icon = icon;
        this.text_name = text_name;
    }

    public Drawable getIcon() {
        return icon;
    }

    public String getText_name() {
        return text_name;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public void setText_name(String text_name) {
        this.text_name = text_name;
    }
}
