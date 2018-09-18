package com.exampleDemo.ThreadTest;

public class TestIncr {
    volatile int i = 0;

    public void incrValue() {
        for (int n=0; n<=100099; n++) {
            System.out.println(Thread.currentThread().getName() + ":" + ++i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestIncr source = new TestIncr();
        Thread thread_01 = new Thread(new ExecuteDemo(source), "Thread-01");
        thread_01.start();
//        thread_01.join();
        Thread thread_02 = new Thread(new ExecuteDemo(source), "Thread-02");
        thread_02.start();

    }
}

class ExecuteDemo implements Runnable {
    TestIncr source;

    public ExecuteDemo(TestIncr source) {
        this.source = source;
    }

    @Override
    public void run() {
        source.incrValue();
    }
}