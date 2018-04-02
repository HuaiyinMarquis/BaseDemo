package com.homework.designTest.singleton;

/**
 * Created by ChenMP on 2018/3/17.
 */
public class TestSingleton {
    public static void main(String[] args) {
        SingletonObject instance = Six_Enum.OBJECTDATE.getInstance();
        SingletonObject instance2 = Six_Enum.OBJECTDATE.getInstance();
        System.out.println(instance == instance2);
    }
}
