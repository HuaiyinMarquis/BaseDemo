package com.exampleDemo.ThreadTest;

import java.util.concurrent.CountDownLatch;

/**
 * Created by ChenMP on 2018/3/21.
 */
public class TestInterrupted {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            try {
                new TestInterrupted().doInterrupted();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        thread.interrupt();
    }

    public void doInterrupted() throws InterruptedException {
        System.out.println("inner doInterrupted...");
        while (true)
            System.out.println("Main Thread continue to running...");
//        Thread.currentThread().interrupt();
    }
}
