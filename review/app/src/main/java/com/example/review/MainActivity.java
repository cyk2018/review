package com.example.review;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Animal> mData = null;
    private Context mContext;
    private AnimalAdapter mAdapter = null;
    private ListView list_animal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        ActionBar actionBar = getActionBar();
//        actionBar.hide();
        mContext = MainActivity.this;
        list_animal = findViewById(R.id.list_animal);
        mData = new LinkedList<Animal>();


        mData.add(new Animal("3-3-1", "基于监听的事件机制", R.mipmap.ic_icon_dog));
        mData.add(new Animal("3-3", "Handler", R.mipmap.ic_icon_cat));
        mData.add(new Animal("4-1-2", "页面传递信息", R.mipmap.ic_icon_cat));
        mData.add(new Animal("6-1", "文件读写", R.mipmap.ic_icon_cat));
        mData.add(new Animal("6-2", "SharedPreference", R.mipmap.ic_icon_cat));
        mData.add(new Animal("7-1-3", "HttpUrlConnection", R.mipmap.ic_icon_cat));

        mAdapter = new AnimalAdapter((LinkedList<Animal>) mData, mContext);
        list_animal.setAdapter(mAdapter);

        list_animal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
//                        Toast.makeText(mContext, "跳转到" + ++i + "页", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, re331.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, re33.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, re412.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, re61.class));
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this, re_6_2.class));
                        break;
                    case 5:
                        startActivity(new Intent(MainActivity.this, re7_1_3.class));
                        break;
                }

            }
        });
    }

//    private long exitTime = 0;
//
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if(keyCode == KeyEvent.KEYCODE_BACK) {
//            if((System.currentTimeMillis() - exitTime) > 2000) {
//                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
//                exitTime = System.currentTimeMillis();
//            }
//            else {
//                finish();
//                System.exit(0);
//
//            }
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }
}