package com.example.demo.DesignPattern.CreationalPatterns.AbstractFactoryPattern;

import com.example.demo.DesignPattern.CreationalPatterns.AbstractFactoryPattern.bean.Color;
import com.example.demo.DesignPattern.CreationalPatterns.FactoryPattern.bean.Shape;

/**
 * Created by ChenMP on 2017/11/8.
 */
public abstract class AbstractFactory {
    abstract Color getColor(String color);
    abstract Shape getShape(String shape);
}
