package com.lilili.abstractt;

/**
 * @Author LiYuan
 * @Date 2021/12/7
 **/
public class AbstractTest {
    public static void main(String[] args) {
        AbstractAnimal rabbit = new Rabbit("小兔");
        AbstractAnimal tiger = new Tiger("大老虎");
        rabbit.eat();
        rabbit.running();
        tiger.eat();
        tiger.running();
    }
}
