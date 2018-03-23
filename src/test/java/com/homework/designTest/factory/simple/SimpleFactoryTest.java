package com.homework.designTest.factory.simple;

/**
 * 简单工厂的实质是：
 *      由一个工厂类根据传入的参数，动态决定该生产那个产品类
 * Created by ChenMP on 2018/3/4.
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        SimpleFactory.get("YiLi").get();
    }
}
