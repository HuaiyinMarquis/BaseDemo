package com.designTest.factory.Normal;

import com.designTest.factory.Milk;
import com.designTest.factory.YiLi;

/**
 * Created by ChenMP on 2018/3/4.
 */
public class YiLiFactory implements MilkFactory {

    @Override
    public Milk getMilk() {
        return new YiLi();
    }
}
