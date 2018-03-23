package com.example.demo.ThreadTest;

/**
 * Created by ChenMP on 2018/3/21.
 */
public class TestInterrupted {
    public static void main(String[] args) throws InterruptedException {
        new TestInterrupted().doInterrupted();
    }

    public void doInterrupted() throws InterruptedException {
        Thread.currentThread().interrupt();
        System.out.println("Main Thread continue to running...");
//        Thread.sleep(2000);
//        synchronized (TestInterrupted.class) {
//            wait();
//        }
        System.out.println("end");
    }
}
