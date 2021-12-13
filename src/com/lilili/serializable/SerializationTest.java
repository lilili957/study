package com.lilili.serializable;

import java.io.*;

/**
 * @Author LiYuan
 * @Date 2021/12/8
 **/
public class SerializationTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student("张三", 10);
        Student student2 = new Student("张四", 11);
        student.setStudent(new Student("李丽丽", 20));
        student2.setStudent(new Student("韩汉涵", 20));
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bout);
        oos.writeObject(student);
        oos.writeObject(student2);
        System.out.println(bout);
        ByteArrayInputStream bis = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        System.out.println(bis.available());
        Student o = (Student)ois.readObject();
        Student o1 = (Student) ois.readObject();
//        Student s;
//        //循环读取流对象里的数据，直到没有数据
//        while ((s = (Student) ois.readObject()) != null) {
//            System.out.println(s);
//        }
        o.getStudent().setName("lilili");
        o1.getStudent().setName("lilili");
        System.out.println("-------序列化后并且修改值-----");
        System.out.println(o);
        System.out.println(o1);
        System.out.println("--------原对象----------");
        System.out.println(student);
        System.out.println(student2);
        //可以看到这里已经完成了深度克隆， o,o1的修改不会影响原对象。
    }
}
