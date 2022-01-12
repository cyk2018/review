package com.example.review;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class re33 extends AppCompatActivity {

    static final String UPPER_NUM = "upper";
    EditText etNum;
    CalThread calThread;

    class CalThread extends Thread
    {
        public Handler mHandler;

        public void run()
        {
            Looper.prepare();// 子线程中使用Handler要重写Looper

            mHandler = new Handler()
            {
                @Override
                public void handleMessage(@NonNull Message msg) {
                    if(msg.what == 0x123) {
                        int upper = msg.getData().getInt(UPPER_NUM);
                        List<Integer> nums = new ArrayList<Integer>();
                        outer:
                        for(int i = 2; i <= upper; i++) {
                            for(int j = 2; j <= Math.sqrt(i); j++) {
                                if(i != 2 && i % j == 0) {
                                    continue outer;
                                }
                            }
                            nums.add(i);
                        }
                        TextView res_hint = findViewById(R.id.res_hint);
                        TextView result = findViewById(R.id.result);
                        res_hint.setText(upper + "以内的质数有：");
                        result.setText(nums.toString());
                    }
                }
            };
            Looper.loop();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re33);

        etNum = findViewById(R.id.etNum);
        calThread = new CalThread();
        calThread.start();
    }

    public void cal(View source) {
        Message msg = new Message();
        msg.what = 0x123;
        Bundle bundle = new Bundle();
        bundle.putInt(UPPER_NUM, Integer.parseInt(etNum.getText().toString()));
        msg.setData(bundle);
        calThread.mHandler.sendMessage(msg);
    }
}