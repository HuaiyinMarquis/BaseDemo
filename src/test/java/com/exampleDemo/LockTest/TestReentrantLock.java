package com.exampleDemo.LockTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ChenMP on 2018/3/29.
 */
public class TestReentrantLock {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        boolean tryLock = lock.tryLock();
    }
}
