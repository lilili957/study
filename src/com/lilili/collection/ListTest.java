package com.lilili.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author LiYuan
 * @Date 2021/10/25
 **/
public class ListTest {

    @Test
    public void test01() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        System.out.println(list);
    }

    /**
     * 2021-11-17
     */
    @Test
    public void test02() {
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        List<Integer> list2 = new ArrayList<Integer>();
//        list2.add(1);
        list1.removeAll(list2);
        System.out.println(list1);
    }

    /**
     * 2021-12-03
     */
    @Test
    public void test03() {
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        List<Integer> list2 = list1;

        list2.remove(0);

        System.out.println(list1);
        System.out.println(list2);
    }
}
