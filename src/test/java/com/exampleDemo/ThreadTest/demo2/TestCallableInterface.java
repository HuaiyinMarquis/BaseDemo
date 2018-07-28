package com.exampleDemo.ThreadTest.demo2;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by ChenMP on 2018/3/27.
 */
public class TestCallableInterface {
    public static void main(String[] args) throws Exception {
        for (int i=0; i<10; i++) {
            MyCallable callable = new MyCallable();
            FutureTask<String> task = new FutureTask<>(callable);
            new Thread(task,"Thread-"+i).start();
            System.out.println(task.get());
        }
    }
}

class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName();
    }
}
