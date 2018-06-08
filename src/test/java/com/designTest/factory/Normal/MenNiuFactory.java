package com.designTest.factory.Normal;

import com.designTest.factory.MenNiu;
import com.designTest.factory.Milk;

/**
 * Created by ChenMP on 2018/3/4.
 */
public class MenNiuFactory implements MilkFactory {
    @Override
    public Milk getMilk() {
        return new MenNiu();
    }
}
