package com.lilili.polymorphism;

/**
 * @Author LiYuan
 * @Date 2021/12/7
 **/
public class Rabbit extends AbstractAnimal {
    public Rabbit(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println("rabbit:" + name +", 正在啃东西");
    }

    @Override
    public void running() {
        System.out.println("rabbit:" + name + ", 正在跳着跑");
    }
}
