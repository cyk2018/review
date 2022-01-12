package com.example.review;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class PostUtils {
    public static String LOGIN_URL = "https://172.16.2.54:8000/HttpTest/ServletForPost";

    public static String LoginByPost(String number, String passwd) {
        String msg = "";
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(LOGIN_URL).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setConnectTimeout(5000);

            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            String data = "passwd=" + URLEncoder.encode(passwd, "UTF-8") + "&number=" + URLEncoder.encode(number, "UTF-8");
            OutputStream out = httpURLConnection.getOutputStream();
            out.write(data.getBytes());
            out.flush();
            if(httpURLConnection.getResponseCode() == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                ByteArrayOutputStream message = new ByteArrayOutputStream();
                int len = 0;
                byte buffer[] = new byte[1024];
                while((len = inputStream.read(buffer)) != -1) {
                    message.write(buffer, 0, len);
                }
                inputStream.close();
                message.close();
                msg = new String(message.toByteArray());
                return msg;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }
}
