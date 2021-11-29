package com.lilili.check;

import org.junit.Test;

import java.util.Objects;

/**
 * @Author LiYuan
 * @Date 2021/11/24
 **/
public class CheckStudy {
    private String string;

    @Test
    public void testObjectsCheck() {
        String str = null;
      Objects.requireNonNull(str, "str为空");
    }
}
