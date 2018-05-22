package com.exampleDemo.DesignPattern.CreationalPatterns.FactoryPattern;

import com.exampleDemo.DesignPattern.CreationalPatterns.FactoryPattern.bean.Circle;
import com.exampleDemo.DesignPattern.CreationalPatterns.FactoryPattern.bean.Rectangle;
import com.exampleDemo.DesignPattern.CreationalPatterns.FactoryPattern.bean.Shape;
import com.exampleDemo.DesignPattern.CreationalPatterns.FactoryPattern.bean.Square;
import org.springframework.util.StringUtils;

/**
 * Created by ChenMP on 2017/11/8.
 */
public class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (StringUtils.isEmpty(shapeType))
            return null;

        Shape shape = null;
        switch (shapeType) {
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
