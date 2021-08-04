package com.lilili.annotation.notnull;

import com.sun.istack.internal.NotNull;
import org.omg.CosNaming.NamingContextPackage.NotEmpty;

/**
 * @Date: 2021/6/4
 * @USER: liyuan
 * @test:
 * @NotNull注解适用于基本类型
 * @NotEmpty注解适用于集合
 * @NotBlank注解适用于String类型
 **/
public class NotNullAndNullTest {

    public String name;
    public static void notNull(@NotNull int i) {
        System.out.println(i);
    }

//    public static void notEmpty(@NotBlank StringTest msg) {
//
//    }
    public static void main(String[] args) {
        notNull(1);
        System.out.println(notNull(1, 2));
    }

    @NotNull
    public static Object notNull(int i, int j) {
        return null;
    }
}
