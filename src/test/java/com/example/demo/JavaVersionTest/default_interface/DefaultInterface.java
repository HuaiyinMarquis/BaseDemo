package com.example.demo.JavaVersionTest.default_interface;

/**
 * Created by ChenMP on 2017/10/31.
 */
public interface DefaultInterface {
    void methodOne();

    default void methodTwo() {
        System.out.println("=====do methodTwo=====");
    }
}
