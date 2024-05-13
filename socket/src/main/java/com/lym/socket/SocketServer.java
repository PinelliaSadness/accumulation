package com.lym.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public static void main(String[] args) throws IOException {

        //创建服务端ServerSocket
        ServerSocket serverSocket = new ServerSocket();
        //绑定端口和IP,如果不绑定IP则默认为本机的IP
        serverSocket.bind(new InetSocketAddress("172.16.4.127", 8888));

        //监听端口(堵塞,等待他人链接)
        Socket socket = serverSocket.accept();

        //获取收到的资源
        InputStream inputStream = socket.getInputStream();

        byte[] buf = new byte[1024 * 1024];
        int len;
        while((len = inputStream.read(buf)) != -1){
            System.out.println(new String(buf, 0, len));
        }

        inputStream.close();
        socket.close();
    }
}
