package com.lilili.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author LiYuan
 * @Date 2021/12/8
 **/
public class ReflectionTest {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<Student> studentClass = Student.class;
        Method method = studentClass.getDeclaredMethod("method", null);
        method.setAccessible(true);
        Student student = studentClass.newInstance();
        method.invoke(student);
    }
}
