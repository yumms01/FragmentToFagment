package com.example.tacademy.fragmenttofagment;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Tacademy on 2016-02-24.
 */
public class Reservation_View_3 extends FrameLayout {
    public Reservation_View_3(Context context) {
        super(context);
        init();
    }

    ImageView iconView;
    TextView text_name;
    Reservation_Item_3 item;

    public interface OnImageClickListener {
        public void onImageClick(Reservation_View_3 view, Reservation_Item_3 item);
    }
    OnImageClickListener mImageClickListener;
    public void setOnImageClickListener(OnImageClickListener listener) {
        mImageClickListener = listener;
    }

    private void init() {
        inflate(getContext(), R.layout.view_reservation_3, this);
        iconView = (ImageView)findViewById(R.id.image_icon);
        text_name = (TextView)findViewById(R.id.text_email);

        iconView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mImageClickListener != null) {
                    mImageClickListener.onImageClick(Reservation_View_3.this, item);
                }
            }
        });
    }

    public void setData(Reservation_Item_3 n) {
        item = n;
        if (n.getIcon() != null) {
            iconView.setImageDrawable(n.getIcon());
        } else {
            iconView.setImageResource(R.mipmap.ic_launcher);
        }
        text_name.setText(n.getText_name());
    }
}
