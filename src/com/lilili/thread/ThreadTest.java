package com.lilili.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author LiYuan
 * @Date 2021/12/8
 **/
public class ThreadTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableImpl callable = new CallableImpl();
        FutureTask futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask, "task");
        thread.start();
        System.out.println(futureTask.get());
    }
}
