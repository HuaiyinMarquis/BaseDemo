package com.designTest.singleton;

/**
 * 懒汉二：线程安全，性能差
 * Created by ChenMP on 2018/3/17.
 */
public class Two {
    private static Two two;
    private Two() {}

    public static synchronized Two getInstance() {
        if (null == two)
            two = new Two();
        return two;
    }
}
