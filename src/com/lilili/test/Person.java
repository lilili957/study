package com.lilili.test;

/**
 * @Author LiYuan
 * @Date 2021/8/6
 **/
public class Person {
    public String name;
    public float height;
    public int gender;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", gender=" + gender +
                '}';
    }
}
