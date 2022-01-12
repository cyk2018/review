package com.example.review;

import android.view.View;
import android.widget.Toast;

public class MyClick implements View.OnClickListener {
    public MyClick() {
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "你点击了按钮", Toast.LENGTH_SHORT).show();
    }
}
