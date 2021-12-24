package com.lilili.stream;

import java.io.Serializable;

/**
 * @Author LiYuan
 * @Date 2021/12/22
 **/
public class Student  implements Serializable {
    private static final long SerialVersionUID = 1L;

    public String name;
    public String nickName;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
