package com.example.demo.DesignPattern.CreationalPatterns.AbstractFactoryPattern.bean;

/**
 * Created by ChenMP on 2017/11/8.
 */
public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("Blue->fill()");
    }
}
