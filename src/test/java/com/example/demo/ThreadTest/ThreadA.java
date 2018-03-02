package com.example.demo.ThreadTest;

/**
 * Created by ChenMP on 2017/12/8.
 */
public class ThreadA {
    public static void main(String[] args) {
        ThreadB b = new ThreadB();
        Object obj = new Object();
        b.start();//主线程中启动另外一个线程
        System.out.println("b is start....");

        synchronized(b) {
            try {
                System.out.println("Waiting for b to complete...");
                b.wait();
                System.out.println("ThreadB is Completed. Now back to main thread");
            }catch (InterruptedException e){}
        }
        System.out.println("Total is :" + b.total);
    }
}

class ThreadB extends Thread {
    int total;
    public void run() {
        synchronized(this) {
            System.out.println("ThreadB is running..");
            for (int i=0; i<=100; i++ ) {
                total += i;
            }
            System.out.println("total is " + total);
            notify();
        }
    }
}
