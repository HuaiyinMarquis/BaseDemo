package com.exampleDemo.DesignPattern.CreationalPatterns.AbstractFactoryPattern.bean;

/**
 * Created by ChenMP on 2017/11/8.
 */
public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("Green->fill()");
    }
}
