package com.lilili.date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author LiYuan
 * @Date 2021/11/16
 **/
public class DateTest {

    /**
     * 拿到今天在一周之中的位置
     */
    @Test
    public void test01() {
        Calendar c = Calendar.getInstance();
        int index = c.get(Calendar.DAY_OF_WEEK);

        System.out.println(index);
    }

    /**
     * 拿到今天在本月之中的位置
     */
    @Test
    public void test02() {
        Calendar c = Calendar.getInstance();
        int index = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(index);
        c.add(Calendar.MONTH, -1);
        int actualMaximum = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println("本月的天数" + actualMaximum);
    }

    /**
     * 测试大写YYYY和小写yyyy的区别
     * YYYY：跨年的周会将年份算成下一年
     */
    @Test
    public void testUpCase() {
        Date today = Calendar.getInstance().getTime();
        System.out.println(today);
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String formatToday = format.format(today);
        System.out.println(formatToday);
    }
}
