package com.homework.designTest.factory.Abstract;

import com.homework.designTest.factory.Milk;

/**
 * 抽象工厂模式：
 *      抽象方法实现
 * Created by ChenMP on 2018/3/4.
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        Milk menNiu = new AbstractFactoryImpl().getMenNiu();
        menNiu.get();
    }
}

