package com.example.review;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetData {
    public static byte[] getImage(String path) throws Exception {
        URL url = new URL(path);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setRequestMethod("GET");
        if(httpURLConnection.getResponseCode() != 200) {
            throw new RuntimeException("url请求失败");
        }
        InputStream inputStream = httpURLConnection.getInputStream();
        byte[] bytes = StreamTool.read(inputStream);
        inputStream.close();
        return bytes;
    }

    public static String getHtml(String path) throws Exception {
        URL url = new URL(path);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setRequestMethod("GET");
        if(httpURLConnection.getResponseCode() == 200) {
            InputStream inputStream = httpURLConnection.getInputStream();
            byte[] data = StreamTool.read(inputStream);
            String html = new String(data, "UTF-8");
            return html;
        }
        return null;
    }

}
