package com.homework.designTest.prototype;

import java.util.Arrays;

/**
 * 浅克隆
 * Created by ChenMP on 2018/3/23.
 */
public class Apple implements Cloneable {
    private String color;
    private int size;
    private int[] someThing;
    private OtherInApple otherInApple;

    public Apple(String color, int size ,int[] someThing,OtherInApple otherInApple) {
        this.color = color;
        this.size = size;
        this.someThing = someThing;
        this.otherInApple = otherInApple;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int[] getSomeThing() {
        return someThing;
    }

    public void setSomeThing(int[] someThing) {
        this.someThing = someThing;
    }

    public OtherInApple getOtherInApple() {
        return otherInApple;
    }

    public void setOtherInApple(OtherInApple otherInApple) {
        this.otherInApple = otherInApple;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", size=" + size +
                ", someThing=" + Arrays.toString(someThing) +
                ", otherInApple=" + otherInApple +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
