package com.exampleDemo.DesignPattern.CreationalPatterns.AbstractFactoryPattern;

/**
 * Created by ChenMP on 2017/11/8.
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        AbstractFactory colorFactory = FactoryProducer.getFactory("color");

        colorFactory.getColor("Read").fill();
    }
}
