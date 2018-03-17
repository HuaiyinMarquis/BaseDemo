package com.homework.designTest.factory;

/**
 * Created by ChenMP on 2018/3/4.
 */
public class MenNiu implements Milk  {
    @Override
    public void get() {
        new Thread().join();
        System.out.println("This is MenNiu...");
    }
}
