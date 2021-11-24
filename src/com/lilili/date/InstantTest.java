package com.lilili.date;

import org.junit.Test;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author LiYuan
 * @Date 2021/10/28
 **/
public class InstantTest {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(now);
        System.out.println("getEpochSecond: " + now.getEpochSecond());
        Date date = new Date(1635401519);
        System.out.println(date);

        System.out.println(Instant.ofEpochSecond(1635401400));
    }

    @Test
    public void testSubtilize() {
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date yesterday = calendar.getTime();
        System.out.println("--------Date-------");
        System.out.println("today: " + today + ", yesterday: " + yesterday);

        Instant instToday = today.toInstant();
        Instant instYesterday = yesterday.toInstant();
        System.out.println("--------Instant-------");
        System.out.println("instToday: " + instToday + ", instYesterday: " + instYesterday);

        long instTodayEpoch = instToday.getEpochSecond();
        long instYesterdayEpochEpoch = instYesterday.getEpochSecond();
        System.out.println("--------InstantEpoch-------");
        System.out.println("instTodayEpoch: " + instTodayEpoch + ", instYesterdayEpochEpoch: " + instYesterdayEpochEpoch);
        System.out.println("instTodayEpoch - instYesterdayEpochEpoch = " + (instTodayEpoch - instYesterdayEpochEpoch)/60 + "m");
    }
}
