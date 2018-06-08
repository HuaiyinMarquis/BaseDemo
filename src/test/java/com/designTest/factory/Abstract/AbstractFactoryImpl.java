package com.designTest.factory.Abstract;

import com.designTest.factory.MenNiu;
import com.designTest.factory.Milk;
import com.designTest.factory.YiLi;

/**
 * Created by ChenMP on 2018/3/4.
 */
public class AbstractFactoryImpl implements AbstractFactory {
    @Override
    public Milk getMenNiu() {
        return new MenNiu();
    }

    @Override
    public Milk getYiLi() {
        return new YiLi();
    }
}
