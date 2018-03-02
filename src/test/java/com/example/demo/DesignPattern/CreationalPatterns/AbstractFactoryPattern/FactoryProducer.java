package com.example.demo.DesignPattern.CreationalPatterns.AbstractFactoryPattern;

/**
 * Created by ChenMP on 2017/11/8.
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        } else if(choice.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }
        return null;
    }
}
