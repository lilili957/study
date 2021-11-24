package com.lilili.date;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Calendar;

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
}
