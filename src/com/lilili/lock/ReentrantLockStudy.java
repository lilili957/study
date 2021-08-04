package com.lilili.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;


/**
 * @Author LiYuan
 * @Date 2021/8/3
 **/
public class ReentrantLockStudy {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            pool.submit(new MyReentrantLock(i, new LockEvent()));
        }
    }
}

class MyReentrantLock implements Runnable {
    LockEvent lockEvent;
    private int id;

    public MyReentrantLock(int id, LockEvent lockEvent) {
        this.id = id;
        this.lockEvent = lockEvent;
    }

    @Override
    public void run() {
        lockEvent.print(id);
    }
}

class LockEvent {
    //    private static final Logger LOGGER = Logger.getLogger("com.lilili.lock.LockEvent");
    private ReentrantLock lock = new ReentrantLock(true);

    public void print(int str) {
        try {
            lock.lock();
            System.out.println(str + "号---获得");
            Thread.sleep((long) Math.random() * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println(str + "号---释放");
        }
    }
}
