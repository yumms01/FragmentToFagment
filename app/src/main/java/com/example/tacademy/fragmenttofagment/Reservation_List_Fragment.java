package com.example.tacademy.fragmenttofagment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Reservation_List_Fragment extends Fragment {

    // ListView
    ListView listView;
    Reservation_Adapter_3 list_mAdapter;

    public Reservation_List_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reservation_list, container, false);

        listView = (ListView)view.findViewById(R.id.listView);
        list_mAdapter = new Reservation_Adapter_3();
        list_mAdapter.setOnAdapterItemClickListener(new Reservation_Adapter_3.OnAdapterItemClickListener() {
            @Override
            public void onAdapterItemClickListener(Reservation_Adapter_3 adapter, Reservation_View_3 view, Reservation_Item_3 item, int position) {
                Toast.makeText(getContext(), "ImageClick : " + item.getText_name(), Toast.LENGTH_SHORT).show();
            }
        });

        listView.setAdapter(list_mAdapter);
        List_initData();

        Button btn = (Button)view.findViewById(R.id.btn_reservation);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "예약 완료 화면 이동", Toast.LENGTH_SHORT).show();

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.container, new Reservation_Complete_Fragment());
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        return view;
    }

    // Restaurant Data
    static final String[] Reservation_menu = {"시간", "인원", "메뉴", "요청사항"};
    private void List_initData() {
        for ( int i = 0 ; i < Reservation_menu.length ; i ++ ) {
            Reservation_Item_3 n = new Reservation_Item_3(null, Reservation_menu[i]);

            list_mAdapter.add(n);
        }
    }

}
