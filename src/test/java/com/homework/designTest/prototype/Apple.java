package com.homework.designTest.prototype;

import java.io.*;
import java.util.Arrays;

/**
 * 浅克隆
 * Created by ChenMP on 2018/3/23.
 */
public class Apple implements Cloneable,Serializable {
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

    public Apple deepClone() { //TODO  深克隆
        ByteArrayOutputStream outputStream = null;
        ObjectOutputStream objectOutputStream = null;
        ByteArrayInputStream inputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            outputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(this);

            inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            objectInputStream = new ObjectInputStream(inputStream);
            Apple apple = (Apple) objectInputStream.readObject();
            return apple;
        } catch (IOException|ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != objectOutputStream) {
                    objectInputStream.close();
                    objectInputStream = null;
                }
                if (null != outputStream) {
                    outputStream.close();
                    outputStream = null;
                }
                if (null != objectInputStream) {
                    objectInputStream.close();
                    objectInputStream = null;
                }
                if (null != inputStream) {
                    inputStream.close();
                    inputStream = null;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
