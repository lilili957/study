package com.lilili.polymorphism;

/**
 * @Author LiYuan
 * @Date 2021/12/7
 **/
public class AbstractAnimal {
    public String name;

    public AbstractAnimal(String name) {
        this.name = name;
    }

    public void eat(){};

    public void running(){};
}
