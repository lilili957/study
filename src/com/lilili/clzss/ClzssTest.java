package com.lilili.clzss;

/**
 * @Author LiYuan
 * @Date 2021/12/8
 **/
public class ClzssTest {
    public static void main(String[] args) throws ClassNotFoundException {
        //拿到class对象的三种方法
        //1。类名.class 将类型装入内存， 不做初始化操作
        Class<Student> studentClass1 = Student.class;
        //2.对象.getClass()
        Student student = new Student();
        Class<? extends Student> aClass = student.getClass();
//        //3.Class.forName(类名) 做静态初始化操作
        Class<?> aClass1 = Class.forName("com.lilili.clzss.Student");
    }
}
