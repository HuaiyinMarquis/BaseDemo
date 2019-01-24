package com.JVMTest;

public class TestDeadLock {

    public static void main(String[] args) {
        TestDeadLock resource1 = new TestDeadLock();
        TestDeadLock resource2 = new TestDeadLock();

        new Thread(new DeadLockThread(resource1,resource2),"Thread-01").start();
        new Thread(new DeadLockThread(resource2,resource1),"Thread-02").start();
    }
}

