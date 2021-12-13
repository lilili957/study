package com.lilili.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author LiYuan
 * @Date 2021/12/9
 **/
public class ObjectProxy implements InvocationHandler {

    private Object object;

    public ObjectProxy(Object object) {
        this.object = object;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行目标方法前...");
        System.out.println("对目标方法进行加强");
        Object invoke = method.invoke(object, args);
        System.out.println("目标方法执行结束");
        return invoke;
    }
}
