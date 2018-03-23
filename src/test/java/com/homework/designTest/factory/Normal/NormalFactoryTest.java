package com.homework.designTest.factory.Normal;

/**
 * 普通工厂模式：
 *      创建不同的工厂获取不同的对象
 * Created by ChenMP on 2018/3/4.
 */
public class NormalFactoryTest {
    public static void main(String[] args) {
        MilkFactory factory = new MenNiuFactory();

        factory.getMilk().get();
    }
}
