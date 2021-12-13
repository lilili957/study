package com.lilili.test;

import org.junit.experimental.theories.suppliers.TestedOn;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

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
        String s = (String) o;
        System.out.println(s);
    }

    @org.junit.Test
    public void testEqualsIgnoreCase() {
        System.out.println("3nnn".equalsIgnoreCase("3nNn"));
    }

    @org.junit.Test
    public void breakForEach() {
        a:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    System.out.println("i:" + i + ", j:" + j + ", k:" + k);
                    break a;
                }
            }
        }
    }

    @org.junit.Test
    public void test06() {
//        System.out.println(1 | 0);
        int n = 5;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i <= n; i++) {
            list.add(5 | i);
        }
        System.out.println(list);
    }

    @org.junit.Test
    public void test07() {
//        System.out.println(Math.round(-1.6));
        ArrayList<Integer> list = new ArrayList<>();
        list.add(null);
        System.out.println(list);
        HashSet<Integer> set = new HashSet<>();
        set.add(null);
        System.out.println(set);
    }

    @org.junit.Test
    public void test08() {
        String s1 = "我爱中国";
        byte[] bytes = s1.getBytes();
        System.out.println(Arrays.toString(bytes));
    }

    @org.junit.Test
    public void test09() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
//        for (Integer integer : list) {
////            list.remove(integer);
//                list.add(integer + 10);
//        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            System.out.println(value);
            if (value == 1) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }

    @org.junit.Test
    public void test10() {
        List list = new ArrayList();
        list.add("1");
        list.add("3");
        list.add("5");

        for (Object o : list) {
            if ("3".equals(o))
                list.remove(o);
        }
        System.out.println(list);
    }

    /**
     * 创建一个只读的集合
     */
    @org.junit.Test
    public void test11() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        Collection<Integer> unmodifiableCollection = Collections.unmodifiableCollection(list);
        //这里会报错 .UnsupportedOperationException
        unmodifiableCollection.add(2);
    }

    /**
     * callable创建线程
     */
    @org.junit.Test
    public void test12() throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            System.out.println("call方法");
            return 1;
        });

        Thread t1 = new Thread(futureTask);
        t1.start();
        System.out.println(futureTask.get());
    }
}
