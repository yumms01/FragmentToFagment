package com.example.tacademy.fragmenttofagment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tacademy on 2016-02-24.
 */
public class Reservation_Adapter_3 extends BaseAdapter implements Reservation_View_3.OnImageClickListener{
    List<Reservation_Item_3> items = new ArrayList<Reservation_Item_3>();

    public void add(Reservation_Item_3 f) {
        items.add(f);
        notifyDataSetChanged();
    }

    public void addAll(List<Reservation_Item_3> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Reservation_View_3 view;
        if (convertView == null) {
            view = new Reservation_View_3(parent.getContext());
            view.setOnImageClickListener(this);
        } else {
            view = (Reservation_View_3)convertView;
        }
        view.setData(items.get(position));
        return view;
    }

    public interface OnAdapterItemClickListener {
        public void onAdapterItemClickListener(Reservation_Adapter_3 adapter, Reservation_View_3 view, Reservation_Item_3 item, int position);
    }
    OnAdapterItemClickListener mAdapterListener;
    public void setOnAdapterItemClickListener(OnAdapterItemClickListener listener) {
        mAdapterListener = listener;
    }

    @Override
    public void onImageClick(Reservation_View_3 view, Reservation_Item_3 item) {
        if (mAdapterListener != null) {
            int index = items.indexOf(item);
            mAdapterListener.onAdapterItemClickListener(this, view, item, index);
        }
    }
}
