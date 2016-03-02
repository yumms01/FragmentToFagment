package com.example.tacademy.fragmenttofagment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class Reservation_Main_Fragment extends Fragment {

    // 액티비티 상단 위 구성
    TextView text_time, text_person, text_menu, text_complete;
    ImageView imageView1, imageView2, imageView3;

    public Reservation_Main_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_reservation_main, container, false);

        if (savedInstanceState == null) {
            FragmentTransaction ft = getChildFragmentManager().beginTransaction();
            ft.replace(R.id.container, new Reservation_List_Fragment());
            ft.commit();
        }

        return view;
    }

}
