package com.example.tacademy.fragmenttofagment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Tacademy on 2016-02-24.
 */
public class InLocal_Restaurant_View_2 extends FrameLayout{
    public InLocal_Restaurant_View_2(Context context) {
        super(context);
        init();
    }

    ImageView backGroundView, iconView;
    TextView text_restaurant_name, text_location, text_menu;
    InLocal_Restaurant_Item_2 item;

    public interface OnImageClickListener {
        public void onImageClick(InLocal_Restaurant_View_2 view, InLocal_Restaurant_Item_2 item);
    }
    OnImageClickListener mImageClickListener;
    public void setOnImageClickListener(OnImageClickListener listener) {
        mImageClickListener = listener;
    }

    private void init() {
        inflate(getContext(), R.layout.view_inlocal_restaurant_2, this);
        backGroundView = (ImageView)findViewById(R.id.Local_Restaurant_icon);
        iconView = (ImageView)findViewById(R.id.image_icon);
        text_restaurant_name = (TextView)findViewById(R.id.text_restaurant_name);
        text_location = (TextView)findViewById(R.id.text_location);
        text_menu = (TextView)findViewById(R.id.text_menu);

        backGroundView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mImageClickListener != null) {
                    mImageClickListener.onImageClick(InLocal_Restaurant_View_2.this, item);
                }
            }
        });
    }

    public void setData(InLocal_Restaurant_Item_2 n) {
        item = n;
        if (n.getIcon() != null) {
            backGroundView.setImageDrawable(n.getIcon());
            iconView.setImageDrawable(n.getIcon());
        } else {
            backGroundView.setImageResource(R.mipmap.ic_launcher);
            iconView.setImageResource(R.mipmap.ic_launcher);
        }
        text_restaurant_name.setText(n.getText_restaurant_name());
        text_location.setText(n.getText_location());
        text_menu.setText(n.getText_menu());
    }
}
