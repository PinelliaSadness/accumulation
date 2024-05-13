package com.lym.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketClient {

    public static void main(String[] args) throws IOException {

        // 创建Socket
        Socket socket = new Socket();
        // 使用socket进行连接（套接字：IP + 端口号），三次握手底层已帮我们实现
        socket.connect(new InetSocketAddress("172.16.4.127", 8888));
        // 发送消息
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello server!".getBytes());

        outputStream.close();
        socket.close();
    }
}
