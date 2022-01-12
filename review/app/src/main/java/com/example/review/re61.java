package com.example.review;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class re61 extends AppCompatActivity {

    private EditText file_name;
    private EditText file_content;
    private Button btn_file_write;
    private Button btn_file_clear;
    private Button btn_file_read;
    private Context mContext;
    private TextView show_file_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re61);

        mContext = getApplicationContext();
        bindViews();
    }

    private void bindViews() {
        file_name = findViewById(R.id.in_file_name);
        file_content = findViewById(R.id.in_file_content);
        btn_file_write = findViewById(R.id.btn_file_write);
        btn_file_clear = findViewById(R.id.btn_file_clear);
        btn_file_read = findViewById(R.id.btn_file_read);
        show_file_content = findViewById(R.id.file_content);

        btn_file_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileHelper fileHelper = new FileHelper(mContext);
                String filename =file_name.getText().toString();
                String filecontent = file_content.getText().toString();
                try {
                    fileHelper.save(filename, filecontent);
                    Toast.makeText(getApplicationContext(), "数据写入成功", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "数据写入失败", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_file_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                file_name.setText("");
                file_content.setText("");
            }
        });

        btn_file_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String filecontent = "";
                String filename = file_name.getText().toString();
                FileHelper fileHelper = new FileHelper(mContext);
                try {
                    filecontent = fileHelper.read(filename);
                    show_file_content.setText(filecontent);
                    Toast.makeText(getApplicationContext(), "文件读取成功", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "文件读取失败", Toast.LENGTH_SHORT).show();
                    show_file_content.setText("");
                }

            }
        });

    }
}