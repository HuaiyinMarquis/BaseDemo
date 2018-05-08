package com.exampleDemo.ClassloaderTest.DiffWithClassForName;

/**
 * Created by ChenMP on 2018/3/29.
 */
public class JavaBean {
    private static Integer num;
    static {
        System.out.println("static Code Running...");
    }
    {
        System.out.println("normal Code Running...");
    }

    public JavaBean() {
        System.out.println("Create Method Running");
    }
}
