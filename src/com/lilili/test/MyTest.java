package com.lilili.test;

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
}
