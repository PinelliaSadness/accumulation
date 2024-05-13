package com.lym.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();

        String str = "我是udp的发送方式";
        byte[] data = str.getBytes();
        InetAddress inetAddress = InetAddress.getLocalHost();

        // 打包成数据包发送
        DatagramPacket packet = new DatagramPacket(data, 0, data.length, inetAddress, 9090);// 放送给主机
        // 直接发送
        datagramSocket.send(packet);

        datagramSocket.close();
    }
}
