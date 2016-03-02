package com.example.tacademy.fragmenttofagment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private static final int REQUEST_CODE_OTHER = 0;

    // ViewPager
    ViewPager pager;
    ViewPagerAdapter_Restaurant vp_mAdapter;

    // ListView
    ListView listView;
    Local_Restaurant_Adapter_1 list_mAdapter;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        // ViewPager
        pager = (ViewPager)view.findViewById(R.id.pager_main);
        vp_mAdapter = new ViewPagerAdapter_Restaurant();
        pager.setAdapter(vp_mAdapter);
        pager.setPageMargin(10);
        Pager_initData();
        pager.setCurrentItem(0);

        // ListView
        listView = (ListView)view.findViewById(R.id.listview_main);
        list_mAdapter = new Local_Restaurant_Adapter_1();
        list_mAdapter.setOnAdapterItemClickListener(new Local_Restaurant_Adapter_1.OnAdapterItemClickListener() {
            @Override
            public void onAdapterItemClickListener(Local_Restaurant_Adapter_1 adapter, Local_Restaurant_View_1 view, Local_Restaurant_Item_1 item, int position) {
                Toast.makeText(getContext(), "ImageClick : " + item.getName(), Toast.LENGTH_SHORT).show();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.container, new InLocal_Restaurant_Fragment());
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        listView.setAdapter(list_mAdapter);
        List_initData();

        return view;
    }

    //VIewPager Data
    private void Pager_initData() {
        for (int i = 0; i < 10; i++) {
            vp_mAdapter.add("item : " + i);
        }
    }

    // Restaurant Data
    static final String[] Local_Restaurant = {"강남구 레스토랑", "종로구 레스토랑", "마포구 레스토랑", "성동구 레스토랑", "성북구 레스토랑"};
    private void List_initData() {
        for ( int i = 0 ; i < Local_Restaurant.length ; i ++ ) {
            Local_Restaurant_Item_1 n = new Local_Restaurant_Item_1(null, Local_Restaurant[i]);

            list_mAdapter.add(n);
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            getActivity().setTitle("DINER");
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }
}
