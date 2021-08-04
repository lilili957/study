package com.lilili.newfeature;

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
    }
}

class User {
    public String name;
    public String getName() {
        return name;
    }
}


