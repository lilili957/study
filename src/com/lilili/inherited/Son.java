package com.lilili.inherited;

/**
 * @Author LiYuan
 * @Date 2021/12/7
 **/
public class Son extends Father {
    public Son(String name) {
        super(name);
    }

    @Override
    public void showName() {
        System.out.println("Son: SonName");
    }


    public static void staticMethod(){
        System.out.println("son的静态方法");
    }
}
