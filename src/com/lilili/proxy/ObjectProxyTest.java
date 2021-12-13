package com.lilili.proxy;

import com.lilili.clzss.Student;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author LiYuan
 * @Date 2021/12/9
 **/
public class ObjectProxyTest {
    public static void main(String[] args) {
//        ObjectProxy objectProxy = new ObjectProxy(new StudentServiceImpl());
//        StudentService studentService = (StudentService) objectProxy.getProxy();
//        studentService.info();

        StudentServiceImpl target = new StudentServiceImpl();
        StudentService proxy = (StudentService) getProxy(target);
        proxy.info();
    }

    /**
     * 简便写法
     */
    @Test
    public void proxyTest02() {
        StudentServiceImpl target = new StudentServiceImpl();
        StudentService studentService = (StudentService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{StudentService.class}, (proxy, method, args) -> {
            System.out.println("代理前...");
            System.out.println("增强处理");
            Object result = method.invoke(target, args);
            System.out.println("代理结束");
            return result;
        });
        studentService.info();
    }

    /**
     * 通用代理方法
     */

    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), (proxy, method, args) -> {
            System.out.println("代理前...");
            System.out.println("增强处理");
            Object result = method.invoke(target, args);
            System.out.println("代理结束");
            return result;
        });

    }
}
