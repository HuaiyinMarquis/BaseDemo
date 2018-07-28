package com.exampleDemo.ThreadLocalTest;

import java.util.concurrent.CountDownLatch;

/**
 * Created by ChenMP on 2018/3/23.
 */
public class TestReference {
    private static Index index = new Index();
    private static CountDownLatch latch = new CountDownLatch(10);
    public static final ThreadLocal<Index> local = new ThreadLocal<Index>() {
        @Override
        protected Index initialValue() {
            super.initialValue();
            return index;
        }
    };

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        for (int i=0; i<10; i++) {
            threads[i] = new Thread(()->{
                Index obj = local.get();
                obj.incr();
                System.out.println(Thread.currentThread().getName()+"->"+obj.num);
            },"Thread-"+i);
        }

        for (Thread thread : threads) {
            thread.start();
            latch.countDown();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Index {
        int num;

        public void incr() {
            num++;
        }
    }
}
