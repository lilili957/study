package com.lilili.socket.udpupload;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author LiYuan
 * @Date 2021/12/31
 **/
public class UploadServer {
    public static void main(String[] args) {
        System.out.println("服务器开启。。。");
        new Thread(() -> {
            try {
                DatagramSocket socket = new DatagramSocket(10001);
                FileChannel channel = new FileOutputStream(new File("D:\\Demo\\stream\\kk-01.jpg")).getChannel();
                while (true) {
                    byte[] buffer = new byte[1024];
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    socket.receive(packet);
                    if (new String(buffer, 0, 3).equals("bye")) {
                        break;
                    }
                    channel.write(ByteBuffer.wrap(buffer));
                }
                System.out.println("接收文件结束。。。");
                socket.close();
                channel.close();
            } catch (SocketException | FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
