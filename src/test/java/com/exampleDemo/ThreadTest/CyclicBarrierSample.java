package com.exampleDemo.ThreadTest;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierSample {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5,() -> {
            System.out.println("Action go ..... again!");
        });

        for (int i=1; i<6; i++) {
            new Thread(new CyclicBarrierWorker(cyclicBarrier),"Thread-"+i).start();
        }
    }
}

class CyclicBarrierWorker implements Runnable {
    private CyclicBarrier cyclicBarrier;

    public CyclicBarrierWorker(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        for (int i=0; i<3; i++) {
            try {
                System.out.println(Thread.currentThread().getName() +"：第" + (i+1) + "次do SomeThing");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}