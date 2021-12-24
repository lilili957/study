package com.lilili.stream;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

/**
 * @Author LiYuan
 * @Date 2021/12/22
 **/
public class ByteTest {

    @Test
    public void testByteArrayInputStream() throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream("this is byte array".getBytes());

        byte[] b = new byte[1024];
        int c = 0;
        StringBuilder sb = new StringBuilder();
        while ((c = bais.read()) != -1) {
            sb.append((char) c);
        }
        System.out.println(sb.toString());
    }

    @Test
    public void testObjectInputStream() throws IOException, ClassNotFoundException {
        Student student = new Student();
        student.name = "张三";
        student.nickName = "张麻子";

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(student);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Object o = ois.readObject();

        System.out.println((Student)o);
    }

    @Test
    public void testFileInputStream() throws IOException {
        File file = new File("D:\\Demo\\stream\\file1.txt");
        File outFile = new File("D:\\Demo\\stream\\file2.txt");
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream foos = new FileOutputStream(outFile);

        byte[] b = new byte[10];
        int len;
        while ((len = fis.read(b)) != -1) {
            foos.write(b, 0, len);
        }
        foos.flush();
        fis.close();
        foos.close();
    }
}
