package com.example.demo.JavaVersionTest.default_interface;

/**
 * Created by ChenMP on 2017/10/31.
 */
public class DefaClass implements DefaultInterface {
    @Override
    public void methodOne() {

    }

    @Override
    public void methodTwo() {//不能引用接口default方法
//        super.methodTwo();
        System.out.println("=========the new one=========");
    }

    public static void main(String[] args) {
        new DefaClass().methodTwo();
    }
}
