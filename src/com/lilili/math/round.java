package com.lilili.math;

import java.text.DecimalFormat;

/**
 * @Date: 2021/6/15
 * @USER: liyuan
 * @test:
 **/
public class round {
    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("0%");
        System.out.println(decimalFormat.format(0.157));
    }
}
