package com.lilili.lock;

import org.junit.internal.runners.statements.RunAfters;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author LiYuan
 * @Date 2021/8/4
 **/
public class LockSupportStudy implements Runnable {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    private Thread thread;

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        System.out.println(String.format("%s-步入run方法，线程名%s", FORMATTER.format(LocalDateTime.now()), Thread.currentThread().getName()));
        LockSupport.park();
        System.out.println(String.format("%s-解除阻塞，线程继续执行，线程名%s", FORMATTER.format(LocalDateTime.now()), Thread.currentThread().getName()));
    }

    private void unpark() {
        LockSupport.unpark(thread);
    }

    public static void main(String[] args) throws InterruptedException {
        LockSupportStudy main = new LockSupportStudy();
        Thread thread = new Thread(main, "main");
        main.setThread(thread);
        thread.start();
        Thread.sleep(3000);
//        main.unpark();
        LockSupport.unpark(thread);
        Thread.sleep(2000);
    }
}