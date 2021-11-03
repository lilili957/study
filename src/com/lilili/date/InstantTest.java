package com.lilili.date;

import java.time.Instant;
import java.util.Date;

/**
 * @Author LiYuan
 * @Date 2021/10/28
 **/
public class InstantTest {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(now);
        System.out.println("getEpochSecond: "  + now.getEpochSecond());
        Date date = new Date(1635401519);
        System.out.println(date);

        System.out.println(Instant.ofEpochSecond(1635401400));
    }
}
