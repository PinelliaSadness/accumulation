package com.lym.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9090);

        byte[] bytef = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytef, 0, bytef.length);

        //接收
        datagramSocket.receive(datagramPacket);
        byte[] data = datagramPacket.getData();
        int length = datagramPacket.getLength();
        String str = new String(data, 0, length);
        System.out.println(str);

        datagramSocket.close();
    }
}
