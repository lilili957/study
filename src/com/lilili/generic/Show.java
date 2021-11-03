package com.lilili.generic;

/**
 * @Author LiYuan
 * @Date 2021/10/27
 **/
public class Show<T> {

    //静态方法使用泛型的时候返回值前要写上泛型， 不然会提示编译不通过
    public static <T> void print(T t) {
        System.out.println(t);
    }

    public static void main(String[] args) {
        print("打印");
    }
}
