package com.designTest.singleton;

/**
 * 懒汉一 :线程不安全
 * Created by ChenMP on 2018/3/17.
 */
public class One {
    private static One one;
    private One(){}

    public static One getInstance() {
        if (null == one)
            one = new One();
        return one;
    }
}
