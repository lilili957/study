package com.lilili.reflection;

/**
 * @Author LiYuan
 * @Date 2021/12/8
 **/
public class Student {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void method() {
        System.out.println("私有方法");
    }
}
