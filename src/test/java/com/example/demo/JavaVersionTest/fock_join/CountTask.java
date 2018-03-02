package com.example.demo.JavaVersionTest.fock_join;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by ChenMP on 2017/10/31.
 */
public class CountTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 4;//阀值
    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;

        boolean  canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (int i=start; i<=end; i++) {
                sum += i;
            }
        } else {
            //如果任务大于阀值，则分裂成两个子任务计算
            int middle = (start + end)/2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle+1, end);
            //执行子任务
            leftTask.fork();
            rightTask.fork();

            int leftResult = leftTask.join();
            int rightResult = rightTask.join();
            //合并子任务
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //生成一个计算任务，计算1+2+3+.....+16
        CountTask countTask = new CountTask(1, 16);
        //执行一个任务
        ForkJoinTask<Integer> result = forkJoinPool.submit(countTask);
        try {
            System.out.println(result.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
