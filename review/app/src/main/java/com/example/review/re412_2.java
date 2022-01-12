package com.example.review;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class re412_2 extends AppCompatActivity {

    private TextView res_register;
    private String username;
    private String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re4122);

        res_register = findViewById(R.id.res_register);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        username = bundle.getString("username");
        String gender_from = bundle.getString("gender");
        if(gender_from.equals("男")) {
            gender = "先生";
        }
        else {
            gender = "女士";
        }
        res_register.setText("恭喜！" + username + gender + "注册成功" );
    }
}