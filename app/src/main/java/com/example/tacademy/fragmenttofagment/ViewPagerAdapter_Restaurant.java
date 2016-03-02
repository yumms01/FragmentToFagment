package com.example.tacademy.fragmenttofagment;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dongja94 on 2016-01-26.
 */
public class ViewPagerAdapter_Restaurant extends PagerAdapter {
    List<String> items = new ArrayList<String>();
    List<View> scrappedView = new ArrayList<View>();

    public void add(String item) {
        items.add(item);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public float getPageWidth(int position) {
        return 1;
}

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        TextView textView = null;

        if (scrappedView.size() > 0) {
            View scrapView = scrappedView.remove(0);
            textView = (TextView)scrapView;
        } else {
            textView = new TextView(container.getContext());
            textView.setBackgroundColor(Color.GREEN);
        }

        textView.setText(items.get(position));

        container.addView(textView);
        return textView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View)object;
        container.removeView(view);
        scrappedView.add(view);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
