package com.exampleDemo.DesignPattern.CreationalPatterns.FactoryPattern;

import com.exampleDemo.DesignPattern.CreationalPatterns.FactoryPattern.bean.Shape;

/**
 * Created by ChenMP on 2017/11/8.
 */
public class ShapeFactoryTest {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape square = shapeFactory.getShape("Square");
        square.draw();
    }
}
