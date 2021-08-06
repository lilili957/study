package com.lilili.test;

/**
 * @Author LiYuan
 * @Date 2021/8/6
 **/
public class ForcedTransferTest {
    public static void main(String[] args) {
        Person person = new Person();
        person.gender = 1;
        person.name = "lilili957";
        person.height = 1.87f;
        System.out.println(person);
        Object obj = (Object) person;
        System.out.println(obj);
    }
}
