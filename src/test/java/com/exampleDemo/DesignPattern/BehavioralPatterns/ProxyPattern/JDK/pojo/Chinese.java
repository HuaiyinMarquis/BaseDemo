package com.exampleDemo.DesignPattern.BehavioralPatterns.ProxyPattern.JDK.pojo;

/**
 * Created by ChenMP on 2018/1/9.
 */
public class Chinese implements Person {

    @Override
    public String run() {
        System.out.println("Running....");
        return "OK";
    }

    @Override
    public String eat() {
        System.out.println("Eating....");
        return "OK";
    }
}
