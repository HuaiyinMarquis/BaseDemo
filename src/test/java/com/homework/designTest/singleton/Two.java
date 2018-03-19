package com.homework.designTest.singleton;

/**
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
