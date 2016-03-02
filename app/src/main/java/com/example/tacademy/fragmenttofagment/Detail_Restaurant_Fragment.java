package com.example.tacademy.fragmenttofagment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Detail_Restaurant_Fragment extends Fragment {

    // ViewPager
    ViewPager pager;
    ViewPagerAdapter_Restaurant rmAdapter;

    //TabsPager
    InLocal_TabsAdapter tmAdapter;
    TabHost tabHost;

    public Detail_Restaurant_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_restaurant, container, false);

        // ViewPager
        pager = (ViewPager)view.findViewById(R.id.pager_restaurant);
        rmAdapter = new ViewPagerAdapter_Restaurant();
        pager.setAdapter(rmAdapter);
        pager.setPageMargin(10);

        initData();
        pager.setCurrentItem(0);

        // TabPager
        tabHost = (TabHost)view.findViewById(R.id.tabHost);
        pager = (ViewPager)view.findViewById(R.id.pager);
        tabHost.setup();

        tmAdapter = new InLocal_TabsAdapter(getContext(), getChildFragmentManager(), tabHost, pager);

        tmAdapter.addTab(tabHost.newTabSpec("tab1").setIndicator("기본정보"), Detail_Tab1_Fragment.class, null);
        tmAdapter.addTab(tabHost.newTabSpec("tab2").setIndicator("음식메뉴"), Detail_Tab2_Fragment.class, null);
        tmAdapter.addTab(tabHost.newTabSpec("tab3").setIndicator("혜택"), Detail_Tab3_Fragment.class, null);

        if (savedInstanceState != null) {
            tmAdapter.onRestoreInstanceState(savedInstanceState);
            tabHost.setCurrentTabByTag(savedInstanceState.getString("currentIndex"));
        }

        Button btn = (Button)view.findViewById(R.id.btn_reservation);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Reservation....", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(), Reservation_Activity.class));
            }
        });

        return view;
    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            rmAdapter.add("item : " + i);
        }
    }

}
