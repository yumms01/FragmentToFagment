package com.example.tacademy.fragmenttofagment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tacademy on 2016-02-24.
 */
public class InLocal_Restaurant_Adapter_2 extends BaseAdapter implements InLocal_Restaurant_View_2.OnImageClickListener {
    List<InLocal_Restaurant_Item_2> items = new ArrayList<InLocal_Restaurant_Item_2>();

    public void add(InLocal_Restaurant_Item_2 f) {
        items.add(f);
        notifyDataSetChanged();
    }

    public void addAll(List<InLocal_Restaurant_Item_2> items) {
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
        InLocal_Restaurant_View_2 view;
        if (convertView == null) {
            view = new InLocal_Restaurant_View_2(parent.getContext());
            view.setOnImageClickListener(this);
        } else {
            view = (InLocal_Restaurant_View_2)convertView;
        }
        view.setData(items.get(position));
        return view;
    }

    public interface OnAdapterItemClickListener {
        public void onAdapterItemClickListener(InLocal_Restaurant_Adapter_2 adapter, InLocal_Restaurant_View_2 view, InLocal_Restaurant_Item_2 item, int position);
    }
    OnAdapterItemClickListener mAdapterListener;
    public void setOnAdapterItemClickListener(OnAdapterItemClickListener listener) {
        mAdapterListener = listener;
    }

    @Override
    public void onImageClick(InLocal_Restaurant_View_2 view, InLocal_Restaurant_Item_2 item) {
        if (mAdapterListener != null) {
            int index = items.indexOf(item);
            mAdapterListener.onAdapterItemClickListener(this, view, item, index);
        }
    }
}
