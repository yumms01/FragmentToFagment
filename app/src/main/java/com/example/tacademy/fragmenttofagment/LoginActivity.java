package com.example.tacademy.fragmenttofagment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    ImageView imageView;
    ImageView image_line;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);

        Button btn = (Button)findViewById(R.id.btn_facebook);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "페이스북/구글 가입하기창으로 이동", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, FaceBook_Google_Activity.class));
            }
        });

        btn = (Button)findViewById(R.id.btn_google);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "페이스북/구글 가입하기창으로 이동", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, FaceBook_Google_Activity.class));
            }
        });

        btn = (Button)findViewById(R.id.btn_email);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "이메일 가입하기창으로 이동", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, Email_New_Activity.class));
            }
        });

        btn = (Button)findViewById(R.id.btn_login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "로그인 하기 창으로 이동", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, InLoginActivity.class));
            }
        });
    }
}
