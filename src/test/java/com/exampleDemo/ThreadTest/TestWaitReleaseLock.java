package com.exampleDemo.ThreadTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestWaitReleaseLock {
    public static void main(String[] args) throws InterruptedException, IOException {
        ResourceObj obj = new ResourceObj();
        Thread in = new Thread(() -> {
            try {
                obj.in();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        in.start();
        TimeUnit.SECONDS.sleep(2);
        Thread out = new Thread(() -> {
            obj.out();
        });
        out.start();
        System.in.read();
    }
}

class ResourceObj {
    Object obj = new Object();

    public synchronized void in() throws InterruptedException {
        System.out.println("in方法获取类锁...........");
        synchronized (obj) {
            System.out.println("in方法获取对象锁...........");
            wait();
        }
    }

    public synchronized void out() {
        System.out.println("out方法获取类锁...........");
        synchronized (obj) {
            System.out.println("out方法获取对象锁...........");
            notify();
        }
    }
}
