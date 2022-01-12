package com.example.review;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class re412 extends AppCompatActivity {

    private RadioGroup radioGroup;
    private EditText edUsername;
    private Button btn_register;
    private String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re412);

        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radbtn = findViewById(i);
                gender = radbtn.getText().toString();
                //radbtn.getText()即可获得
            }
        });

        edUsername = findViewById(R.id.username);
        btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(re412.this, re412_2.class);
                Bundle bundle = new Bundle();
                bundle.putString("username", edUsername.getText().toString());
                bundle.putString("gender", gender);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }


}