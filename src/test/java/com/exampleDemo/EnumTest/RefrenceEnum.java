package com.exampleDemo.EnumTest;

/**
 * Created by ChenMP on 2018/3/19.
 */
public enum RefrenceEnum {
    APPLE(new Fruit("apple")),ORANGE(new Fruit("orange")),BANANA(new Fruit("banana"));

    private Fruit fruit;

    RefrenceEnum(Fruit fruit) {
        this.fruit = fruit;
    }

    @Override
    public String toString() {
        return fruit.toString();
    }
}
