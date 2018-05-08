package com.exampleDemo.ThreadTest.demo2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 顺序打印ABC 100次
 * Created by ChenMP on 2018/3/27.
 */
public class TestCondition {

    public static void main(String[] args) {
        PrintSequence sequence = new PrintSequence();
        new Thread(()->{
            for (int i=1; i<=100; i++) {
                    sequence.printA(i);
            }
        },"线程一").start();

        new Thread(()->{
            for (int i=1; i<=100; i++) {
                    sequence.printB(i);
            }
        },"线程二").start();

        new Thread(()->{
            for (int i=1; i<=100; i++) {
                    sequence.printC(i);
            }
        },"线程三").start();
    }
}

class PrintSequence {
    private Lock lock = new ReentrantLock();
    private Integer mark = 1;
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void printA(int num) {
        lock.lock();
        try {
            if (mark != 1) //若不为1的时候，休眠
                condition1.await();
            System.out.println(Thread.currentThread().getName()+"第"+num+"次打印->A");
            mark = 2; //标志可以执行printB方法
            condition2.signal(); //唤醒printB线程
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void printB(int num) {
        lock.lock();
        try {
            if (mark != 2) //若不为1的时候，休眠
                condition2.await();
            System.out.println(Thread.currentThread().getName()+"第"+num+"次打印->B");
            mark = 3; //标志可以执行printB方法
            condition3.signal(); //唤醒printB线程
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void printC(int num) {
        lock.lock();
        try {
            if (mark != 3) //若不为1的时候，休眠
                condition3.await();
            System.out.println(Thread.currentThread().getName()+"第"+num+"次打印->C");
            mark = 1; //标志可以执行printB方法
            condition1.signal(); //唤醒printB线程
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}
