package com.homework.designTest.factory.Normal;

import com.homework.designTest.factory.MenNiu;
import com.homework.designTest.factory.Milk;

/**
 * Created by ChenMP on 2018/3/4.
 */
public class MenNiuFactory implements MilkFactory {
    @Override
    public Milk getMilk() {
        return new MenNiu();
    }
}
