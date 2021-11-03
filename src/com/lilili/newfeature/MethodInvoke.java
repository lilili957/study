package com.lilili.newfeature;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author LiYuan
 * @Date 2021/7/6
 **/
public class MethodInvoke {
    public static void main(String[] args) {
        User user = new User();
        user.name = "李梨离";
        Supplier<String> name = user::getName;
        System.out.println(name.get());
        System.out.println("-------------------------------------------------");
        BiFunction<Integer, Integer, Integer> biFun = Integer::compare;
        Integer apply = biFun.apply(1, 2);
        System.out.println(apply);
        System.out.println("-------------------------------------------------");
        BiFunction<Integer, Object, Boolean> biFun2 = Integer::equals;
        System.out.println(biFun2.apply(1, 2));
        System.out.println("-------------------------------------------------");

    }
}

class User {
    public String name;
    public String getName() {
        return name;
    }
}


