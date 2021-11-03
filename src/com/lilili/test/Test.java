package com.lilili.test;

import org.junit.experimental.theories.suppliers.TestedOn;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @Author LiYuan
 * @Date 2021/6/29
 **/
public class Test {
    private String clzss = "Test";

    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance(Locale.US);
        Date time = instance.getTime();
        System.out.println(instance.getTimeInMillis());
        System.out.println(time);
        String format = new SimpleDateFormat("yyyy-MM-dd").format(time);
        System.out.println(format);
    }

    @org.junit.Test
    public void test01() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Test{" +
                "clzss='" + clzss + '\'' +
                '}';
    }

    @org.junit.Test
    public void test02() {
        List<String> list = null;
        for (String s : list) {
            System.out.println(s);
        }
    }

    @org.junit.Test
    public void test03() {
        System.out.println("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1IiwiZXhwIjoxNjM1NDc2MDQwLCJpYXQiOjE2MzU0NzYwMzB9.RjzDNSd9bPCbHSmx7-4_s1cM7EYptorOLRhLV_JkGwE".equals("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1IiwiZXhwIjoxNjM1NDc2MDQwLCJpYXQiOjE2MzU0NzYwMzB9.RjzDNSd9bPCbHSmx7-4_s1cM7EYptorOLRhLV_JkGwE"));
    }

    @org.junit.Test
    public void test04() {
        String str = "之前的_之后_的";
        System.out.println(str.indexOf("_"));
        String subStr = str.substring(0, str.indexOf("_"));
        System.out.println(subStr);
    }

    //
    @org.junit.Test
    public void test05() {
        Object o = null;
        String s = (String)o;
        System.out.println(s);
    }

    @org.junit.Test
    public void testEqualsIgnoreCase() {
        System.out.println("3nnn".equalsIgnoreCase("3nNn"));
    }
}
