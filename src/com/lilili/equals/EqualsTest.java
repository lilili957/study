package com.lilili.equals;
import com.lilili.equals.Student;
import org.junit.Test;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Date: 2021/6/4
 * @USER: liyuan
 * @test:
 **/
public class EqualsTest {
    public static void main(String[] args) {
        String s = null;
        System.out.println("".equals(s));
        test01();
    }

    /**
     * 2021-12-07
     */
    @Test
    public static void test01() {
        Map<Student, Integer> map = new HashMap<>(16);

        Student s1 = new Student("丽丽", 1);
        Student s2 = new Student("丽丽", 2);
        Student s3 = new Student("丽丽", 1);

        map.put(s1, 1);
        map.put(s2, 2);
        map.put(s3, 3);

        System.out.println("s1.equals(s3): " + s1.equals(s3));
        System.out.println("s1 == s3:" + (s1 == s3));
        System.out.println("s1.hashCode() == s3.hashCode():" + (s1.hashCode() == s3.hashCode()));
        System.out.println(map);

        HashSet<Student> set = new HashSet<>();
        set.add(s1);
        set.add(s2);
        System.out.println(set);
    }
}
