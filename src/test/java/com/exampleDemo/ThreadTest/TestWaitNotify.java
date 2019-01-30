package com.exampleDemo.ThreadTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestWaitNotify {

    public static void main(String[] args) throws InterruptedException, IOException {
        Object obj = new Object();
        Thread thread = new Thread(new LockObject(obj));
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        synchronized (obj) {
//            obj.notify();
            System.in.read();
        }
        System.out.println("notifyAll");
    }
}
class LockObject implements Runnable {
    Object obj;

    public LockObject(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized (obj) {
            try {
                System.out.println("调用本对象的wait()方法...");
//                obj.wait(3000);
                Thread.sleep(3000); //区分这两个的区别，wait是让3秒的锁3秒时候不需要notify自动重新去竞争锁
                System.out.println("喔吼，Thread继续执行...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

