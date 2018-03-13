package com.example.demo.ThreadTest.demo3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ChenMP on 2018/3/7.
 */
public class TestExecutor {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);

        for (int i=0; i<20; i++) {
            service.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "正在运行.............");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

    }
}