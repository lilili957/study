package com.lilili.socket.udpupload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author LiYuan
 * @Date 2021/12/31
 **/
public class UploadClient {
    public static void main(String[] args) {
        System.out.println("客户端开启。。。");
        new Thread(() -> {
            try {
                DatagramSocket socket = new DatagramSocket();
                FileChannel channel = new FileInputStream(new File("D:\\Demo\\stream\\kk.jpg")).getChannel();
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                InetAddress remote = InetAddress.getByName("localhost");
                while (channel.read(buffer) != -1) {
                    //要发送的数据包
                    DatagramPacket packet = new DatagramPacket(buffer.array(), buffer.capacity(), remote, 10001);
                    socket.send(packet);
                    buffer.clear();
                }
                DatagramPacket packet = new DatagramPacket("bye".getBytes(), 3, remote, 10001);
                socket.send(packet);
                socket.close();
                channel.close();
                System.out.println("客户端上传文件结束。。。");
            } catch (SocketException | FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
