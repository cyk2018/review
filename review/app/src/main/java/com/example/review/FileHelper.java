package com.example.review;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileHelper {
    private Context mContext;

    public FileHelper() {

    }
    public FileHelper(Context mContext) {
        super();
        this.mContext = mContext;
    }

    public void save(String filename, String filecontent) throws Exception {
        FileOutputStream output = mContext.openFileOutput(filename, Context.MODE_PRIVATE);
        output.write(filecontent.getBytes());
        output.close();
    }

    public String read(String filename) throws Exception {
        StringBuilder stringBuilder = new StringBuilder("");
        FileInputStream inputStream = mContext.openFileInput(filename);
        byte[] temp = new byte[1024];
        int len = 0;
        while((len = inputStream.read(temp)) > 0) {
            stringBuilder.append(new String(temp, 0, len));
        }
        inputStream.close();
        return stringBuilder.toString();
    }
}
