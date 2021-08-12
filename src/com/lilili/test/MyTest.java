package com.lilili.test;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author LiYuan
 * @Date 2021/8/6
 **/
public class MyTest {
    public static void main(String[] args) {
        Pattern compile = Pattern.compile("");
        Matcher matcher = compile.matcher("");
        matcher.find();
        matcher.group();

        String str = new String();
        new String().toCharArray();
    }

    @Test
    public void test01() {
        Integer[] arr1 = {1, 1, 1, 1, 1};
        Integer[] arr2 = {1, 1, 1, 1, 1};
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i] + arr2[i];
        }
        System.out.println(Arrays.toString(arr2));
    }

    @Test
    public void test02() {
        BigDecimal[] arr1 = new BigDecimal[12];
        Arrays.fill(arr1, new BigDecimal(0));
        BigDecimal b1 = new BigDecimal(1);
        BigDecimal b2 = new BigDecimal(1);
        b2 = b1.add(b2);
        System.out.println(Arrays.toString(arr1));
    }
}
