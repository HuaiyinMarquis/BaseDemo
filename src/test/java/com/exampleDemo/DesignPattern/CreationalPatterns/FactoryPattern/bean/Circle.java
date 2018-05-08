package com.exampleDemo.DesignPattern.CreationalPatterns.FactoryPattern.bean;

/**
 * Created by ChenMP on 2017/11/8.
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle->draw");
    }
}
