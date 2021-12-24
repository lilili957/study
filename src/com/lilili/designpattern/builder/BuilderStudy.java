package com.lilili.designpattern.builder;

/**
 * @Author LiYuan
 * @Date 2021/12/24
 **/
public class BuilderStudy {
    public static void main(String[] args) {
        Director director = new Director(new ConcreteBuilder());
        Product product = director.construct();
        product.show();
    }
}

class Product {
    private String partA;
    private String partB;
    private String partC;

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    public void show() {
        System.out.println("partA: " + partA);
        System.out.println("partB: " + partB);
        System.out.println("partC: " + partC);
    }
}

abstract class AbstractBuilder {
    Product product = new Product();

    public abstract void setPartA();
    //
    public abstract void setPartB();
    //
    public abstract void setPartC();

    public Product getResult() {
        return product;
    }
}

class ConcreteBuilder extends AbstractBuilder {
    @Override
    public void setPartA() {
        product.setPartA("这是PartA");
    }

    @Override
    public void setPartB() {
        product.setPartB("这是PartB");
    }

    @Override
    public void setPartC() {
        product.setPartC("这是PartC");
    }
}

class Director {
    private AbstractBuilder builder;

    public Director(AbstractBuilder builder) {
        this.builder = builder;
    }

    public Product construct() {
        builder.setPartA();
        builder.setPartB();
        builder.setPartC();
        return builder.getResult();
    }
}
