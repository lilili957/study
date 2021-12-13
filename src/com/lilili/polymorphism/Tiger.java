package com.lilili.polymorphism;

/**
 * @Author LiYuan
 * @Date 2021/12/7
 **/
public class Tiger extends AbstractAnimal {

    public Tiger(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println("tiger:" + name + ", 正在撕裂食物");

    }

    @Override
    public void running() {
        System.out.println("tiger:" + name +  ", 正在全速奔跑");
    }
}
