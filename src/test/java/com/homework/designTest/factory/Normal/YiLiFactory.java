package com.homework.designTest.factory.Normal;

import com.homework.designTest.factory.Milk;
import com.homework.designTest.factory.YiLi;

/**
 * Created by ChenMP on 2018/3/4.
 */
public class YiLiFactory implements MilkFactory {

    @Override
    public Milk getMilk() {
        return new YiLi();
    }
}
