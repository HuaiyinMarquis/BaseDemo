package com.exampleDemo.ThreadTest.demo3;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by ChenMP on 2018/3/7.
 */
public class TestWait {
    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        long l = System.currentTimeMillis();
        Object object = new Object();
        new Thread(()->new TestWait().lockMethod(object) ,"thread1").start();
        new Thread(()->new TestWait().lockMethod(object) ,"thread2").start();
        countDownLatch.await();
        l = System.currentTimeMillis() - l;
        System.out.println("执行完所需要的时间为：" + l);
    }

    private void lockMethod(Object object) {
        System.out.println(Thread.currentThread().getName()+":lockMethod....1");
        synchronized (object) {
            System.out.println(Thread.currentThread().getName()+":lockMethod....2");
            try {
                object.wait(3000);
                System.out.println(Thread.currentThread().getName()+":lockMethod....3");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":lockMethod....4");
        }
        countDownLatch.countDown();
    }
}
