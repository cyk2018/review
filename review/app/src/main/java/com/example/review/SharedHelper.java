package com.example.review;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class SharedHelper {
    private Context mContext;

    public SharedHelper() {

    }

    public SharedHelper(Context mContext) {
        this.mContext = mContext;
    }

    public void save(String username, String password) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences("mysp", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.commit();
        Toast.makeText(mContext, "信息已写入", Toast.LENGTH_SHORT).show();
    }

    public Map<String, String> read() {
        Map<String, String> data = new HashMap<String, String>();
        SharedPreferences sharedPreferences = mContext.getSharedPreferences("mysp", Context.MODE_PRIVATE);
        data.put("username", sharedPreferences.getString("username", ""));
        data.put("password", sharedPreferences.getString("password", ""));
        return data;
    }

}
