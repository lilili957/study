package com.lilili.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author LiYuan
 * @Date 2021/9/23
 **/
public class MapTest {

    //CollectionUtil.isEmpty()
    @Test
    public void test01() {
        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("name", "");
        System.out.println(map.isEmpty());
    }

    @Test
    public void testClear() {
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "张三");
        System.out.println(map);
        map.clear();
        System.out.println("clear之后");
        System.out.println(map);
    }
}
