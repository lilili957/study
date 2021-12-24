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
}
