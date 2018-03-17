package com.homework.designTest.factory.Normal;

/**
 * Created by ChenMP on 2018/3/4.
 */
public class NormalFactoryTest {
    public static void main(String[] args) {
        MilkFactory factory = new MenNiuFactory();

        factory.getMilk().get();
    }
}
