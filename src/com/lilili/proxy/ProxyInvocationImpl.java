package com.lilili.proxy;

import sun.rmi.runtime.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Logger;

/**
 * @Author LiYuan
 * @Date 2021/8/12
 **/
public class ProxyInvocationImpl implements InvocationHandler {
    private static final Logger LOGGER = Logger.getLogger("ProxyInvocationImpl");

    private Object target;

    public ProxyInvocationImpl(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke之前...");
        Object result = method.invoke(target, args);
        System.out.println("invoke之后...");
        return result;
    }
}
