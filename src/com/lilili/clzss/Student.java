package com.lilili.clzss;

/**
 * @Author LiYuan
 * @Date 2021/12/8
 **/
public class Student {
    private String name;
    private static String namee;

    static {
        namee = "静态名";
        System.out.println(namee);
        System.out.println("静态代码块");
    }

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public static void setNamee(String namee) {
        Student.namee = namee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
