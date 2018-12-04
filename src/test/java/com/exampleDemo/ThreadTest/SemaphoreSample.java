package com.exampleDemo.ThreadTest;

import java.io.IOException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
//信号量
public class SemaphoreSample {
    public static void main(String[] args) throws IOException {
        Semaphore semaphore = new Semaphore(3);
        for (int i=0; i<10; i++) {
            new Thread(new SemaphoreWorker(semaphore),"Thread_"+i).start();
        }
        System.in.read();
    }
}

class SemaphoreWorker implements Runnable {
    private Semaphore semaphore;

    public SemaphoreWorker(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "：等待获取许可..");
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + "：获取到许可并处理业务逻辑..");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
            System.out.println(Thread.currentThread().getName() + "：释放许可..");
        }
    }
}
