package com.example.demo.GabageCollectionTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ChenMP on 2017/12/8.
 */
public class TestThreadWaitJConsole {
    public static void createBusyThread() {
        Thread thread = new Thread(() -> {
           while (true);
        },"testBusyThread");
        thread.start();
    }

    public static void createLockThread(final Object lock) {
        Thread thread = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"testLockThread");
        thread.start();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        createBusyThread();
        reader.readLine();
        Object obj = new Object();
        createLockThread(obj);
    }
}
