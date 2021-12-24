package com.lilili.stream;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.security.SecureRandom;
import java.util.Random;

/**
 * @Author LiYuan
 * @Date 2021/12/22
 **/
public class NIOTest {

    @Test
    public void testIntBuffer() {
        IntBuffer buffer = IntBuffer.allocate(11);

        //往缓冲区写入两个int类型数据
        for (int i = 0; i < 2; i++) {
            buffer.put(i);
        }
        buffer.flip(); //写模式切换成读模式
        System.out.println("capacity - " + buffer.capacity() + ", position - " + buffer.position() + ", limit - " + buffer.limit());

        //读取buffer里面的数据
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
        System.out.println("capacity - " + buffer.capacity() + ", position - " + buffer.position() + ", limit - " + buffer.limit());
    }

    @Test
    public void testChannel() throws IOException {
        FileChannel inChannel = new FileInputStream("D:\\Demo\\stream\\file1.txt").getChannel();
        FileChannel outChannel = new FileOutputStream("D:\\Demo\\stream\\file2.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(10);
        while (inChannel.read(buffer) != -1) {
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }
        inChannel.close();
        outChannel.close();
    }
}
