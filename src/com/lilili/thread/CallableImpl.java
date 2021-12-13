package com.lilili.thread;

import java.util.concurrent.Callable;

/**
 * @Author LiYuan
 * @Date 2021/12/8
 **/
public class CallableImpl implements Callable<Thread> {
    @Override
    public Thread call() throws Exception {
//        System.out.println(Thread.currentThread());
        return Thread.currentThread();
    }
}
