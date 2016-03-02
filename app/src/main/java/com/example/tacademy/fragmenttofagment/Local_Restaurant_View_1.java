package com.example.tacademy.fragmenttofagment;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Tacademy on 2016-02-23.
 */
public class Local_Restaurant_View_1 extends FrameLayout{
    public Local_Restaurant_View_1(Context context) {
        super(context);
        init();
    }

    ImageView iconView;
    TextView nameView;
    Local_Restaurant_Item_1 item;

    public interface OnImageClickListener {
        public void onImageClick(Local_Restaurant_View_1 view, Local_Restaurant_Item_1 item);
    }
    OnImageClickListener mImageClickListener;
    public void setOnImageClickListener(OnImageClickListener listener) {
        mImageClickListener = listener;
    }

    private void init() {
        inflate(getContext(), R.layout.view_local_restaurant_1, this);
        iconView = (ImageView)findViewById(R.id.Local_Restaurant_icon);
        nameView = (TextView)findViewById(R.id.Local_Restaurant_Name);

        iconView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mImageClickListener != null) {
                    mImageClickListener.onImageClick(Local_Restaurant_View_1.this, item);
                }
            }
        });
    }

    public void setData(Local_Restaurant_Item_1 n) {
        item = n;
        if (n.getIcon() != null) {
            iconView.setImageDrawable(n.getIcon());
        } else {
            iconView.setImageResource(R.mipmap.ic_launcher);
        }
        nameView.setText(n.getName());
    }
}
