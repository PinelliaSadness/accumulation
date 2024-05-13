package com.lym.socket;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;

public class SocketMain {
    public static void main(String[] args) throws Exception {
        InetAddress address = InetAddress.getByName("www.baidu.com");
        System.out.println(address.getHostAddress());

        URL url = new URL("file:///C:\\Users\\DELL\\OneDrive\\文档\\WanShun\\后台管理一组\\2022Q3\\运力信息上报\\运力信息上报sql.txt");
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = url.openConnection().getInputStream();
        byte[] buf = new byte[1024];
        int len;
        while((len = inputStream.read(buf)) != -1){
            System.out.println(new String(buf, 0, len));
        }

    }
}
