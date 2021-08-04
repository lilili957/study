package com.lilili.asser;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author LiYuan
 * @Date 2021/6/30
 **/
public class AssertTest {

    public void asser(int n) {
        //assert关键字的用法， 当表达式为真的时候继续执行程序， 表达式为假的时候终止程序， 如果有express信息的话江将会以字符串的形式表现出来(为真不提示，为假提示)。
        assert (n > 1) : "执行失败";

        assert true : "执行成功";
        assert false : "执行失败";
    }

    @Test
    public void test() {
        asser(2);
    }

    @Test
    public void test01() {
        Assert.assertTrue("执行失败", true);
    }
}
