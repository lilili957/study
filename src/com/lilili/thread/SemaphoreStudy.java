package com.lilili.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author LiYuan
 * @Date 2021/8/2
 **/
public class SemaphoreStudy {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore position = new Semaphore(2);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executorService.submit(() -> {
                try {
                    if (position.availablePermits() > 0) {
                        System.out.println("顾客[" + finalI + "]号进入厕所，有空位");
                    } else {
                        System.out.println("顾客[" + finalI + "]号进入厕所，没有空位，排队");
                    }
                    position.acquire();
                    System.out.println("顾客[" + finalI + "]获得坑位");
                    Thread.sleep((int) (Math.random() * 1000));
                    System.out.println("顾客[" + finalI + "]使用完毕");
                    position.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
        position.acquireUninterruptibly(2);
        System.out.println("使用完毕， 需要清扫了");
        position.release();
    }
}
