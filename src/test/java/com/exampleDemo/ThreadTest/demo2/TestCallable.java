package com.exampleDemo.ThreadTest.demo2;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

/**
 * Created by ChenMP on 2017/11/9.
 */
public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Set<Callable<String>> callables = new HashSet<>();

        callables.add(() -> {
            Thread.sleep(1000);
            System.out.println("线程执行了Task 1");
            return "Task 1";
        });
        callables.add(() -> {
            System.out.println("线程执行了Task 2");
            return "Task 2";
        });
        callables.add(() -> {
            System.out.println("线程执行了Task 3");

            return "Task 3";
        });

        String invokeAny = executorService.invokeAny(callables);
        System.out.println("返回的任务为：" + invokeAny);

//        List<Future<String>> futures = executorService.invokeAll(callables);
//
//        for (Future<String> future :futures) {
//            System.out.println(future.get());
//        }

        executorService.shutdown();
    }
}
