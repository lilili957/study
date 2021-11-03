package com.lilili.annotation.customannotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface UserInfo {
    String user() default "";
}
