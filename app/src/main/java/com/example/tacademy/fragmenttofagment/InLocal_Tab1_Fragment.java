package com.example.tacademy.fragmenttofagment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class InLocal_Tab1_Fragment extends Fragment {
    // ListView
    ListView listView;
    InLocal_Restaurant_Adapter_2 list_mAdapter;

    public InLocal_Tab1_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_in_local_tab1, container, false);

        // ListView
        listView = (ListView)view.findViewById(R.id.listView_namesort);
        list_mAdapter = new InLocal_Restaurant_Adapter_2();
        list_mAdapter.setOnAdapterItemClickListener(new InLocal_Restaurant_Adapter_2.OnAdapterItemClickListener() {
            @Override
            public void onAdapterItemClickListener(InLocal_Restaurant_Adapter_2 adapter, InLocal_Restaurant_View_2 view, InLocal_Restaurant_Item_2 item, int position) {
                Toast.makeText(getContext(), "ImageClick : " + item.getText_restaurant_name(), Toast.LENGTH_SHORT).show();
                FragmentTransaction ft = ((FragmentActivity)getActivity()).getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, new Detail_Restaurant_Fragment());
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        listView.setAdapter(list_mAdapter);
        List_initData();

        return view;
    }


    // Restaurant Data
    static final String[] Local_Restaurant = {"아워프레임", "플레이피쉬", "탐프레이스", "그레이즈", "치르치르", "봉구비어"};
    static final String[] Local_location = {"혜화동", "종로3가", "종로4가", "통인동", "낙성대", "어디든지"};
    static final String[] Local_menu = {"쉬림프 & 파스터 전문점", "생선 요리 전문 레스토랑", "이탈리아 요리 전문 레스토랑", "파스타 요리 전문레스토랑", "치킨 전문", "맥주 전문"};
    private void List_initData() {
        for ( int i = 0 ; i < Local_Restaurant.length ; i ++ ) {
            InLocal_Restaurant_Item_2 n = new InLocal_Restaurant_Item_2(null, Local_Restaurant[i], Local_location[i], Local_menu[i]);

            list_mAdapter.add(n);
        }
    }

}
