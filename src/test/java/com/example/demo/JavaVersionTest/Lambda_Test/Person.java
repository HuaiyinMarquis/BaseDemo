package com.example.demo.JavaVersionTest.Lambda_Test;

/**
 * Created by ChenMP on 2017/11/3.
 */
public class Person {
    private String name;
    private int weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Person(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
}
