package com.homework.designTest.singleton;

/**
 * Created by ChenMP on 2018/3/17.
 */
public class Three {
    private static Three three;
    private Three(){}

    public static Three getInstance() {
        if (null == three) {
            synchronized (Three.class) {
                if (null == three)
                    three = new Three();
            }
        }
        return three;
    }
}
