package com.lilili.date;

import org.junit.Test;

import java.time.Duration;

/**
 * @Author LiYuan
 * @Date 2021/9/30
 **/
public class DurationTest {

    @Test
    public void test01() {
        System.out.println(Duration.ofMinutes(10).equals(Duration.ofSeconds(610)));
    }
}
