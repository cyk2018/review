package com.example.review;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;

public class re7_6_2 extends AppCompatActivity implements Runnable{

    private TextView txtshow;
    private EditText editsend;
    private Button btnsend;
    private static final String HOST = "";
    private static final int PORT = 12345;
    private Socket socket = null;
    private BufferedReader in = null;
    private PrintWriter out = null;
    private String content = "";
    private StringBuilder stringBuilder = null;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            if(msg.what == 0x123) {
                stringBuilder.append(content);
                txtshow.setText(stringBuilder.toString());
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re762);

        stringBuilder = new StringBuilder();
        txtshow = findViewById(R.id.txtShow);
        editsend = findViewById(R.id.editsend);
        btnsend = findViewById(R.id.btn_send);

        new Thread() {
            @Override
            public void run() {
                try {
                    socket = new Socket(HOST, PORT);
                    in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                    out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = editsend.getText().toString();
                if (socket.isConnected()) {
                    if(!socket.isOutputShutdown()) {
                        out.println(msg);
                    }
                }
            }
        });

        new Thread(re7_6_2.this).start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                if(socket.isConnected()) {
                    if(!socket.isInputShutdown()) {
                        content += "\n";
                        handler.sendEmptyMessage(0x123);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}