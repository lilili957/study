package com.lilili.annotation;

import com.lilili.annotation.customannotation.UserInfo;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author LiYuan
 * @Date 2021/9/23
 **/
public class AnnotationTest {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<User> userClazz = User.class;
//        Method[] declaredMethods = userClazz.getDeclaredMethods();
//        Method[] methods = userClazz.getMethods();
        Method method = userClazz.getDeclaredMethod("getUserInfo");

        UserInfo annotation = method.getAnnotation(UserInfo.class);
//        System.out.println(annotation.user());
        //获取注解上面的值，
        Class<? extends Annotation> aClass = annotation.annotationType();
        Method[] declaredMethods = aClass.getDeclaredMethods();
//        System.out.println(Arrays.toString(declaredMethods));
        for (Method md : declaredMethods) {
            Object invoke = md.invoke(annotation);
            System.out.println(invoke == null);
            System.out.println(md.getName());
            System.out.println(invoke);
        }

//        Annotation[] annotations = method.getAnnotations();
//        for (Annotation annotation : annotations) {
//            if (annotation instanceof UserInfo) {
//                System.out.println("match");
//            }
//        }
    }
}

class User {
    String name;
    String passwd;


    @UserInfo(user = "lilili957")
    public String getUserInfo() {
        return "{ name : " + name + ", passwd : " + passwd + " }";
    }

    private void setName(String name) {
        this.name = name;
    }
}
