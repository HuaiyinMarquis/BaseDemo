package com.example.demo.DesignPattern.BehavioralPatterns.ProxyPattern.gclib.pojo;

import com.example.demo.DesignPattern.BehavioralPatterns.ProxyPattern.gclib.CarProxy;

/**
 * Created by ChenMP on 2018/1/10.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Car car = (Car) new CarProxy().getInstance(new Car());
        car.run();
    }
}
