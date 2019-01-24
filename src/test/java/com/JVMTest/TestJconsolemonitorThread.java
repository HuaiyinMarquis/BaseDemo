package com.JVMTest;

import java.util.Scanner;

/**
 * 通过监控
 */
public class TestJconsolemonitorThread {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.next();

        new Thread(()->{
            for (;;) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Thread-01").start();

        TestJconsolemonitorThread lock = new TestJconsolemonitorThread();
        new Thread(()->{
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Thread-02").start();
    }
}
