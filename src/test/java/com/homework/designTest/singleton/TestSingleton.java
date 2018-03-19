package com.homework.designTest.singleton;

/**
 * Created by ChenMP on 2018/3/17.
 */
public class TestSingleton {
    public static void main(String[] args) {
        SingletonObject instance = Six.OBJECTDATE.getInstance();
        SingletonObject instance2 = Six.OBJECTDATE.getInstance();
        System.out.println(instance == instance2);
    }
}
