package com.designTest.proxy;

/**
 * Created by ChenMP on 2018/3/17.
 */
public class Chinese implements Person{
    @Override
    public void eat() {
        System.out.println("Chinese eat something...");
    }
    @Override
    public void go() {
        System.out.println("Chinese do something...");
        eat();
    }
}
