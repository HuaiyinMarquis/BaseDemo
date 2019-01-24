package com.exampleDemo;

public class TestParentStaticMethod extends Parent{
    static void methodOne(){
        System.out.println("son methodOne");
    }

    public static void main(String[] args) {
        methodOne();
    }
}
class Parent {
    static void methodOne(){
        System.out.println("parent methodOne");
    }

    void methodTwo(){

    }
}
