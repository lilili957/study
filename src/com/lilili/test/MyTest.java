package com.lilili.test;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
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

    @Test
    public void test03() {
        MyTest s = new MyTest();
        System.out.println(s.getClass());
        int size = 1024;
        size = size >> 10;
        System.out.println(size);
    }

    @Test
    public void test04() {
        String s = "0,1,,,2,3,4,5";
        System.out.println(s.substring(0, 2));

        Long l = 0L;
        System.out.println(s.contains(l.toString()));
    }

    @Test
    public void test05() {
        HashMap<String, List<String>> map = new HashMap<>();
        ArrayList<String> l1 = new ArrayList<>();
        l1.add("l1");
        l1.add("l2");
        l1.add("l3");
        ArrayList<String> l2 = new ArrayList<>();
        l2.add("l4");
        l2.add("l6");
        l2.add("l8");
        map.put("1", l1);
        map.put("2", l2);
        map.forEach((s, strings) -> {
            System.out.println(s);
            System.out.println(strings);
        });
    }

    @Test
    public void test06() {
        Calendar instance = Calendar.getInstance();
//        Date time = instance.getTime();
//        System.out.println(time);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(instance));
    }

    @Test
    public void test07() {
        long time = System.currentTimeMillis();
        System.out.println(time);
        System.out.println(time / 1000);
        System.out.println(Long.toString(time / 1000));
    }

    @Test
    public void test08() {
        String s = "";
        try {
            if (s != null && s != "") {
                BigDecimal bigDecimal = new BigDecimal(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println(bigDecimal);

    }

    @Test
    public void test09() {
        for (int i = 0; i <= 3000; i ++) {
            for (int j = 0; j <= 3000; j++) {
                System.out.println(j);
            }
        }
    }
}
