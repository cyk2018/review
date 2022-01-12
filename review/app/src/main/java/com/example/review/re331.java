package com.example.review;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class re331 extends AppCompatActivity {

    private Button btn_method1;
    private Button btn_method2;
    private Button btn_method3;
    private Button btn_method4;
    private Button btn_method5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re331);

        btn_method1 = findViewById(R.id.btn_method1);
        btn_method2 = findViewById(R.id.btn_method2);
        btn_method3 = findViewById(R.id.btn_method3);
        btn_method4 = findViewById(R.id.btn_method4);
        btn_method5 = findViewById(R.id.btn_method5);

        btn_method1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "你点击了按钮", Toast.LENGTH_SHORT).show();
            }
        });

//        btn_method2.setOnClickListener(new BtnClickListener());

//        btn_method3.setOnClickListener(new MyClick());


    }

    class BtnClickListener implements View.OnClickListener
    {
        @Override
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(), "你点击了按钮", Toast.LENGTH_SHORT).show();
        }
    }
}