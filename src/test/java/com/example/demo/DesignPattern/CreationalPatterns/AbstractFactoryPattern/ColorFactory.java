package com.example.demo.DesignPattern.CreationalPatterns.AbstractFactoryPattern;

import com.example.demo.DesignPattern.CreationalPatterns.AbstractFactoryPattern.bean.Blue;
import com.example.demo.DesignPattern.CreationalPatterns.AbstractFactoryPattern.bean.Color;
import com.example.demo.DesignPattern.CreationalPatterns.AbstractFactoryPattern.bean.Green;
import com.example.demo.DesignPattern.CreationalPatterns.AbstractFactoryPattern.bean.Read;
import com.example.demo.DesignPattern.CreationalPatterns.FactoryPattern.bean.Shape;

/**
 * Created by ChenMP on 2017/11/8.
 */
public class ColorFactory extends AbstractFactory {
    @Override
    Color getColor(String colorName) {
        Color color = null;

        switch (colorName) {
            case "Blue":
                color = new Blue();
                break;
            case "Read":
                color = new Read();
                break;
            case "Green":
                color = new Green();
                break;
            default:
                color = null;
                break;
        }
        return color;
    }

    @Override
    Shape getShape(String shape) {
        return null;
    }
}
