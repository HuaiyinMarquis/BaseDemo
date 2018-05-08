package com.exampleDemo.DesignPattern.CreationalPatterns.AbstractFactoryPattern;

import com.example.demo.DesignPattern.CreationalPatterns.AbstractFactoryPattern.bean.Color;
import com.example.demo.DesignPattern.CreationalPatterns.FactoryPattern.bean.Circle;
import com.example.demo.DesignPattern.CreationalPatterns.FactoryPattern.bean.Rectangle;
import com.example.demo.DesignPattern.CreationalPatterns.FactoryPattern.bean.Shape;
import com.example.demo.DesignPattern.CreationalPatterns.FactoryPattern.bean.Square;
import com.exampleDemo.DesignPattern.CreationalPatterns.AbstractFactoryPattern.bean.Color;

/**
 * Created by ChenMP on 2017/11/8.
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    Color getColor(String color) {
        return null;
    }

    @Override
    Shape getShape(String shapeName) {
        Shape shape = null;
        switch (shapeName) {
            case "Circle":
                shape = new Circle();
                break;
            case "Rectangle":
                shape = new Rectangle();
                break;
            case "Square":
                shape = new Square();
                break;
            default:
                shape = null;
        }
        return shape;
    }
}
