package com.example.demo.DesignPattern.CreationalPatterns.FactoryPattern.bean;

/**
 * Created by ChenMP on 2017/11/8.
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle->draw()");
    }
}
