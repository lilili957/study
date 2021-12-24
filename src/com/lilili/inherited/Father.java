package com.lilili.inherited;

/**
 * @Author LiYuan
 * @Date 2021/12/7
 **/
public class Father {
    private String name;

    public Father(String name) {
        this.name = name;
    }

    public void showName() {
        System.out.println("Father: " + name);
    }
}
