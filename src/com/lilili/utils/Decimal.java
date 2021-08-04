package com.lilili.utils;

import javax.swing.*;
import java.text.DecimalFormat;

/**
 * @Date: 2021/6/10
 * @USER: liyuan
 * @test:
 **/
public class Decimal {
    public static void main(String[] args) {
        Double value = 0.5111111111111;
        DecimalFormat decimalFormat = new DecimalFormat("0.00%");
        String format = decimalFormat.format(value);
        System.out.println(format);
    }
}
