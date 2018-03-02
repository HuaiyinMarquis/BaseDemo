package com.example.demo.ConstructorTest;

/**
 * Created by ChenMP on 2018/2/27.
 */
public class Father {

    private String name;

    public Father() {
        System.out.println("Father Constructor...");
    }

    public Father(String name) {
        this.name = name;
    }
}
