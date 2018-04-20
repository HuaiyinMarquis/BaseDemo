package com.example.demo.ConstructorTest;

/**
 * Created by ChenMP on 2018/2/27.
 */
public class Father {

    private String name;

    public Father() {
        System.out.println("Father 构造方法");
    }

    {
        System.out.println("Father 对象方法块");
    }

    static{
        System.out.println("Father 静态方法块");
    }

    public Father(String name) {
        this.name = name;
    }
}
