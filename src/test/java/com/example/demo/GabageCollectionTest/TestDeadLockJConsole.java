package com.example.demo.GabageCollectionTest;

/**
 * Created by ChenMP on 2017/12/8.
 */
public class TestDeadLockJConsole {
    static class SynAddRunnable implements Runnable {
        Integer one,two;
        public SynAddRunnable(Integer one, Integer two) {
            this.one = one;
            this.two = two;
        }

        @Override
        public void run() {
            synchronized(one) {
                synchronized (two) {
                    System.out.println(one + two);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(10*1000);
        Integer one = new Integer(1);
        Integer two = new Integer(2);
        for (int i=0; i<100; i++) {
            new Thread(new SynAddRunnable(one,two),i+"A").start();
            new Thread(new SynAddRunnable(two,one),i+"B").start();
        }
    }
}
