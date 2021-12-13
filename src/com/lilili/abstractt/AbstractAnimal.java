package com.lilili.abstractt;

/**
 * @Author LiYuan
 * @Date 2021/12/7
 **/
public abstract class AbstractAnimal {
    public String name;

    public AbstractAnimal(String name) {
        this.name = name;
    }

    public abstract void eat();

    public abstract void running();
}
