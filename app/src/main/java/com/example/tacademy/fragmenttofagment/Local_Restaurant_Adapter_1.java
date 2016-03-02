package com.example.tacademy.fragmenttofagment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tacademy on 2016-02-23.
 */
public class Local_Restaurant_Adapter_1 extends BaseAdapter implements Local_Restaurant_View_1.OnImageClickListener {
    List<Local_Restaurant_Item_1> items = new ArrayList<Local_Restaurant_Item_1>();

    public void add(Local_Restaurant_Item_1 f) {
        items.add(f);
        notifyDataSetChanged();
    }

    public void addAll(List<Local_Restaurant_Item_1> items) {
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
        Local_Restaurant_View_1 view;
        if (convertView == null) {
            view = new Local_Restaurant_View_1(parent.getContext());
            view.setOnImageClickListener(this);
        } else {
            view = (Local_Restaurant_View_1)convertView;
        }
        view.setData(items.get(position));
        return view;
    }

    public interface OnAdapterItemClickListener {
        public void onAdapterItemClickListener(Local_Restaurant_Adapter_1 adapter, Local_Restaurant_View_1 view, Local_Restaurant_Item_1 item, int position);
    }
    OnAdapterItemClickListener mAdapterListener;
    public void setOnAdapterItemClickListener(OnAdapterItemClickListener listener) {
        mAdapterListener = listener;
    }

    @Override
    public void onImageClick(Local_Restaurant_View_1 view, Local_Restaurant_Item_1 item) {
        if (mAdapterListener != null) {
            int index = items.indexOf(item);
            mAdapterListener.onAdapterItemClickListener(this, view, item, index);
        }
    }
}
