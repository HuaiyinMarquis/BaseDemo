package com.example.demo.ThreadTest;


/**
 * Created by ChenMP on 2018/3/7.
 */
public class TestExecutor {

    public synchronized void a() {
        System.out.println("AA");
    }

    public void b() {
        synchronized (this) {

        }
    }

    public void c() {
        synchronized (TestExecutor.class) {

        }
    }

    public void d() throws InterruptedException {
        wait();
    }
}