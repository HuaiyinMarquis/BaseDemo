package com.exampleDemo.ThreadTest;


import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ChenMP on 2018/3/7.
 */
public class TestExecutor {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

    }

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