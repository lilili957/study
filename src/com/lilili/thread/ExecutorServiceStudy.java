package com.lilili.thread;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author LiYuan
 * @Date 2021/7/30
 **/
public class ExecutorServiceStudy {
    @Test
    public void test01() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executorService.execute(() -> {
                try {
                    System.out.println("[" + finalI + "]...start");
                    Thread.sleep((int) Math.random() * 1000);
                    System.out.println("[" + finalI + "]...end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            System.out.println("submit finish");
        }
        executorService.shutdown();
    }

    //使用submit方法提交活的返回值， 就是使用Callable接口
    @Test
    public void test02() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Future<Object> submit = executorService.submit(() -> {
                try {
                    System.out.println("[" + finalI + "]...start");
                    Thread.sleep((int) Math.random() * 1000);
                    System.out.println("[" + finalI + "]...end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return finalI;
            });
            System.out.println("Future<Object>: " + submit.get());
        }
        executorService.shutdown();
    }
}
