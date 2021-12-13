package com.lilili.serializable;

import java.io.Serializable;

/**
 * @Author LiYuan
 * @Date 2021/12/8
 **/
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private Integer age;
    private Student student;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Student getStudent() {
        return student;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", student=" + student +
                '}';
    }
}
