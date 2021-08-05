package com.lilili.unsafe;

import org.junit.runners.model.InitializationError;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Author LiYuan
 * @Date 2021/8/5
 **/
public class UnsafeStudy {
    static final Unsafe unsafe;
    static final long offset;
    private volatile long result = 0;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
            offset = unsafe.objectFieldOffset(UnsafeStudy.class.getDeclaredField("result"));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        UnsafeStudy myUnsafe = new UnsafeStudy();
        System.out.println(unsafe.compareAndSwapLong(myUnsafe, offset, 0, 1));
        System.out.println(myUnsafe.result);

    }
}

