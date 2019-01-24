package com.JVMTest;

public class DeadLockThread implements Runnable {
    private TestDeadLock resource1;
    private TestDeadLock resource2;

    public DeadLockThread(TestDeadLock resource1, TestDeadLock resource2) {
        this.resource1 = resource1;
        this.resource2 = resource2;
    }


    @Override
    public void run() {
        synchronized (resource1) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (resource2) {
                System.out.println(Thread.currentThread().getName() + " -> do something...");
            }
        }
    }
}
