package com.lilili.date;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @Author LiYuan
 * @Date 2021/11/16
 **/
public class LocalDateTest {

    @Test
    public void test01() {
        LocalDate now = LocalDate.now();
        System.out.println(now);
        LocalDateTime nowTime = LocalDateTime.now();
        System.out.println(nowTime);
    }

    @Test
    public void test02() {
        LocalDate now = LocalDate.now();
        LocalDate mid = LocalDate.of(2021, 11, 20);
        LocalDate before = LocalDate.of(2021, 11, 10);
        System.out.println(before);
        Long days = ChronoUnit.DAYS.between(now, before);
        System.out.println(days);

        System.out.println(ChronoUnit.DAYS.between(mid, now));
    }

    @Test
    public void test03() {
        System.out.println(LocalDate.parse("2021-11-16", DateTimeFormatter.ISO_LOCAL_DATE));
    }
}
