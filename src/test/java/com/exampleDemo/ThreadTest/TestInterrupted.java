package com.exampleDemo.ThreadTest;


import java.util.concurrent.TimeUnit;

/**
 * Created by ChenMP on 2018/3/21.
 */
public class TestInterrupted {
    static int runNum = 0;
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
           while (!Thread.currentThread().isInterrupted()) {
               runNum++;
           }
            System.out.println("runNum = " + runNum);
        });
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
