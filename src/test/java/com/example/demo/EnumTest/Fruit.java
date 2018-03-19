package com.example.demo.EnumTest;

/**
 * Created by ChenMP on 2018/3/19.
 */
public class Fruit {
    private String type;

    public Fruit(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "this fruit is " + type;
    }
}
