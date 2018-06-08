package com.exampleDemo.ClassloaderTest.DiffWithClassForName;

/**
 * Created by ChenMP on 2018/3/29.
 */
public class JavaBean {
    private static Integer num = getNum();
    static {
        System.out.println("static Code Running... && num = " + num);
    }
    {
        System.out.println("normal Code Running...");
    }

    public JavaBean() {
        System.out.println("Create Method Running");
    }

    public static Integer getNum() {
        System.out.println("getNum() is called...");
        return 1;
    }
}
