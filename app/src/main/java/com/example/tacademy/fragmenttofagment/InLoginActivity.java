package com.example.tacademy.fragmenttofagment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class InLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_login);

        Button btn = (Button)findViewById(R.id.btn_login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(InLoginActivity.this, "메인 페이지로 이동", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(InLoginActivity.this, MainActivity.class));
            }
        });
    }

}
