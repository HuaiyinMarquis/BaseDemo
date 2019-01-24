package com.exampleDemo.ThreadTest;

import java.util.concurrent.TimeUnit;

public class TestThreadStatus implements Runnable {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"sleeping").start();

        new Thread(() -> {
            synchronized (TestThreadStatus.class) {
                try {
                    TestThreadStatus.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"waitting").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new TestThreadStatus(),"blocking-01").start();
        new Thread(new TestThreadStatus(),"blocking-02").start();

    }


    @Override
    public void run() {
        synchronized (TestThreadStatus.class) {
            while (true) {
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
}
