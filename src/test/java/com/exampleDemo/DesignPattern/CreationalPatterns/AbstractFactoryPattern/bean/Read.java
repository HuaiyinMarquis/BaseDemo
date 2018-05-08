package com.exampleDemo.DesignPattern.CreationalPatterns.AbstractFactoryPattern.bean;

/**
 * Created by ChenMP on 2017/11/8.
 */
public class Read implements Color {
    @Override
    public void fill() {
        System.out.println("Read->fill()");
    }
}
