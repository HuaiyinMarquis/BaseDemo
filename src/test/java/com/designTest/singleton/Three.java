package com.designTest.singleton;

/**
 * 懒汉三：Double Check Lock 因为指令重排，有并发问题
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
