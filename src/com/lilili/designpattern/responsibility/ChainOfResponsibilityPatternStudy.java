package com.lilili.designpattern.responsibility;

/**
 * 责任链模式
 * @Author LiYuan
 * @Date 2021/12/24
 **/
public class ChainOfResponsibilityPatternStudy {
    public static void main(String[] args) {
        ConcreteHanlder1 h1 = new ConcreteHanlder1();
        ConcreteHanlder2 h2 = new ConcreteHanlder2();
        h1.setNext(h2);
        h1.handleRequest(2);
    }
}

abstract class Handler {
    private Handler next;

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    public abstract void handleRequest(int request);
}

class ConcreteHanlder1 extends Handler {
    @Override
    public void handleRequest(int request) {
        if (request == 1) {
            System.out.println("ConcreteHandler1正在处理请求!");
        } else {
            if (getNext() != null) {
                System.out.println("ConcreteHanlder1无法处理请求，请求往后顺延");
                getNext().handleRequest(request);
            } else {
                System.out.println("所有处理器均无法处理请求");
            }
        }
    }
}

class ConcreteHanlder2 extends Handler {
    @Override
    public void handleRequest(int request) {
        if (request == 2) {
            System.out.println("ConcreteHandler2正在处理请求!");
        } else {
            if (getNext() != null) {
                System.out.println("ConcreteHanlder2无法处理请求，请求往后顺延");
                getNext().handleRequest(request);
            } else {
                System.out.println("所有处理器均无法处理请求");
            }
        }
    }
}
