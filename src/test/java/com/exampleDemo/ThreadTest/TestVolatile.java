package com.exampleDemo.ThreadTest;

import java.util.concurrent.TimeUnit;

public class TestVolatile {
    static volatile boolean isStop = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
           while (!isStop){}
            System.out.println("线程执行完毕！");
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        isStop = true;
    }
}
