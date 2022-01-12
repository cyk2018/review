package com.example.review;

import android.app.Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private static final int PORT = 12345;
    private List<Socket> mList = new ArrayList<Socket>();
    private ServerSocket serverSocket = null;
    private ExecutorService executorService = null;

    public static void main(String[] atgs) {
        new Server();
    }

    public Server() {
        try {
            serverSocket = new ServerSocket(PORT);
            executorService = Executors.newCachedThreadPool();
            System.out.println("服务端运行中......\n");
            Socket client = null;
            while (true) {
                client = serverSocket.accept();
                mList.add(client);
                executorService.execute(new Service(client));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class Service implements Runnable {
        private Socket socket;
        private BufferedReader bufferedReader = null;
        private String msg = "";

        public Service(Socket socket) {
            this.socket = socket;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                msg = "用户：" + this.socket.getInetAddress() + " 进入了聊天室" + "，当前在线人数：" + mList.size();
                this.sendmsg();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                while (true) {
                    if((msg = bufferedReader.readLine()) != null) {
                        if(msg.equals("bye")) {
                            System.out.println(".......................");
                            mList.remove(socket);
                            bufferedReader.close();
                            msg = "用户：" + socket.getInetAddress() + "退出了房间，当前在线人数：" + mList.size();
                            socket.close();
                            this.sendmsg();
                            break;
                        } else {
                            msg = socket.getInetAddress() + " 说：" + msg;
                            this.sendmsg();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void sendmsg() {
            System.out.println(msg);
            int num = mList.size();
            for(int i = 0; i < num; i++) {
                Socket socket = mList.get(i);
                PrintWriter pout = null;
                try {
                    pout = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8")), true);
                    pout.println(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}
