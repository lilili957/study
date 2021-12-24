package com.lilili.clzss;

/**
 * @Date 2021/12/14
 **/
public class Person {

    public static int i = 1;

    static {
//        i = 2;
        System.out.println("静态代码块");
    }

    public static void staticMethod() {
        System.out.println("Person的静态方法");
    }
}
