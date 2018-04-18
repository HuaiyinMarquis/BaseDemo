package com.example.demo.JavaVersionTest.Lambda_Test;

/**
 * Created by ChenMP on 2017/11/3.
 */
public class Person {
    private String name;
    private int weight;
    private int age;

    public Person(String name, int weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", age=" + age +
                '}';
    }
}
