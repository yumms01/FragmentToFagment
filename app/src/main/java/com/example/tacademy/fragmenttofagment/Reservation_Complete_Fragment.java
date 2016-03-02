package com.example.tacademy.fragmenttofagment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Reservation_Complete_Fragment extends Fragment {


    ImageView iconView;
    TextView textView;

    public Reservation_Complete_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reservation_complete, container, false);

        iconView = (ImageView)view.findViewById(R.id.image_icon);
        textView = (TextView)view.findViewById(R.id.text_complete);

        Button btn = (Button)view.findViewById(R.id.btn_ok);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "확인확인!!! 메인화면으로!!!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(), MainActivity.class));
            }
        });

        return view;
    }

}
