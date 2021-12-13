package com.lilili.check;

import java.util.Objects;

/**
 * @Author LiYuan
 * @Date 2021/11/25
 **/
public class ObjectCheck {

    public static <T> T[] checkNonNull(T... objects) {
        for (T object : objects) {
            if (object == null) {
                throw new NullPointerException(null + "为空");
            }
            System.out.println(object + "不为空");
        }
        return objects;
    }

    public static <T> T checkNonNull(T object, String errorMessage) {
        if (object == null) {
            throw new NullPointerException(errorMessage);
        }
        return object;
    }

    public static void main(String[] args) {
//        Long l = 1L;
//        Integer i = 1;
//        Double d = 1.2;
//        checkNonNull(l, i, d);
//        Objects.requireNonNull(l);

        //----------------------------
        Long l = null;
        checkNonNull(l, "l为空");
    }
}
