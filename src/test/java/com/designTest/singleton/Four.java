package com.designTest.singleton;

/**
 * 懒汉四：解决内存可见性问题，线程安全
 * Created by ChenMP on 2018/3/17.
 */
public class Four {
    private static volatile Four four;
    private Four() {}

    public static Four getInstance() {
        if (null == four) {
            synchronized (Four.class) {
                if (null == four)
                    four = new Four();
            }
        }
        return four;
    }
}
