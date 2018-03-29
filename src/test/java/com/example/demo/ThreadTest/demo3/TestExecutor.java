package com.example.demo.ThreadTest.demo3;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ChenMP on 2018/3/7.
 */
public class TestExecutor {
    public static void main(String[] args) throws InterruptedException {
        /**
         * new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
         */
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);//设置固定大小的线程池
        /**
         * new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
         */
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();//无界线程池，可以进行自动线程回收
        /**
         * new FinalizableDelegatedExecutorService(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>()));
         */
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();//单个后台线程池
        CountDownLatch latch = new CountDownLatch(20);
        long before = System.currentTimeMillis();

        for (int i=0; i<20; i++) {
            fixedThreadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "正在运行.............");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        for (int i=0; i<20; i++) {
            cachedThreadPool.execute(()->{
                System.out.println(Thread.currentThread().getName() + "正在运行.............");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
            });
        }

        for (int i=0; i<20; i++) {
            singleThreadExecutor.execute(()->{
                System.out.println(Thread.currentThread().getName() + "正在运行.............");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                latch.countDown();
            });
        }

        latch.await();
        System.out.println("所耗费的时间为："+(System.currentTimeMillis()-before));
        fixedThreadPool.shutdown();
        cachedThreadPool.shutdown();
        singleThreadExecutor.shutdown();

    }
}