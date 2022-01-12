package com.example.review;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Map;

public class re_6_2 extends AppCompatActivity {

    private EditText input_username;
    private EditText input_password;
    private Button btn_login;
    private String username;
    private String password;
    private SharedHelper sharedHelper;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re62);

        mContext = getApplicationContext();
        sharedHelper = new SharedHelper(mContext);
        bindViews();
    }

    private void bindViews() {
        input_username = findViewById(R.id.input_username);
        input_password = findViewById(R.id.input_password);
        btn_login = findViewById(R.id.btn_login_6_2);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = input_username.getText().toString();
                password = input_password.getText().toString();
                sharedHelper.save(username, password);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Map<String, String>data = sharedHelper.read();
        input_username.setText(data.get("username"));
        input_password.setText(data.get("password"));
    }
}