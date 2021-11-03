package com.lilili.thread;

import org.junit.Test;

import java.util.concurrent.*;

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
//        executorService.execute(() -> {
//            System.out.println(Thread.currentThread().getName());
//        });
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

    //CountDownLatch
    @Test
    public void testCountDownLatch() throws InterruptedException {
        Thread.currentThread().setName("主线程");

        CountDownLatch countDownLatch = new CountDownLatch(10);

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0 ; i < 10; i++) {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "...");
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName());
    }

    //CyclicBarrier
    @Test
    public void testCyclicBarrier() throws BrokenBarrierException, InterruptedException {
        Thread.currentThread().setName("主线程");

        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0 ; i < 10; i++) {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "...");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        cyclicBarrier.await();
        System.out.println(Thread.currentThread().getName());
    }
}
