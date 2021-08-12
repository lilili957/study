package com.lilili.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.logging.Logger;

/**
 * @Author LiYuan
 * @Date 2021/8/12
 **/
public class ProxyTest {
    private static final Logger LOGGER = Logger.getLogger("ProxyImpl");

    public static void main(String[] args) {
        ProxyInvocationImpl handler = new ProxyInvocationImpl(new UserDaoImpl());
        UserDao proxy = (UserDao) handler.getProxy();
        proxy.printMsg("动态代理实现");
        LOGGER.info("测试结束");
//        InvocationHandler handler = ((proxy, method, args1) -> {
//            System.out.println("你被代理了");
//            return proxy;
//        });
//        UserDao proxy = (UserDao) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{UserDao.class}, handler);
//        proxy.printMsg("动态代理");
//        LOGGER.info("测试结束");
    }
}
