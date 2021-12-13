package com.lilili.annotation.inherited;

import java.lang.annotation.Annotation;
import java.util.Arrays;

/**
 * @Author LiYuan
 * @Date 2021/12/13
 **/
public class InheritedTest {
    public static void main(String[] args) {
        Class<Son> sonClass = Son.class;
        //获取该类拥有的注解
        Annotation[] annotations = sonClass.getDeclaredAnnotations();
        //获取该类包括其父类的注解
        Annotation[] annotations1 = sonClass.getAnnotations();
        System.out.println(Arrays.toString(annotations));
        System.out.println(Arrays.toString(annotations1));
    }
}

@Fruit
class Father {

}

class Son extends Father {

}