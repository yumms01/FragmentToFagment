package com.example.tacademy.fragmenttofagment;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class InLocal_Restaurant_Fragment extends Fragment {

    // TabPager
    ViewPager pager;
    InLocal_TabsAdapter mAdapter;
    TabHost tabHost;
    
    public InLocal_Restaurant_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_in_local_restaurant, container, false);

        // TabPager
        tabHost = (TabHost)view.findViewById(R.id.tabHost);
        pager = (ViewPager)view.findViewById(R.id.pager);
        tabHost.setup();

        mAdapter = new InLocal_TabsAdapter(getContext(), getChildFragmentManager(), tabHost, pager);

        mAdapter.addTab(tabHost.newTabSpec("tab1").setIndicator("이름"), InLocal_Tab1_Fragment.class, null);
        mAdapter.addTab(tabHost.newTabSpec("tab2").setIndicator("가격대"), InLocal_Tab2_Fragment.class, null);
        mAdapter.addTab(tabHost.newTabSpec("tab3").setIndicator("별점"), InLocal_Tab3_Fragment.class, null);

        if (savedInstanceState != null) {
            mAdapter.onRestoreInstanceState(savedInstanceState);
            tabHost.setCurrentTabByTag(savedInstanceState.getString("currentIndex"));
        }

        return view;
    }

}
