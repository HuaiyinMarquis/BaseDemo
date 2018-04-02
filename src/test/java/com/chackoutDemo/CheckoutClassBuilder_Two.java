package com.chackoutDemo;

import java.util.Vector;

/**
 * subject：遇到多个构造器参数时要考虑用构建器
 * Created by ChenMP on 2018/4/2.
 */
public class CheckoutClassBuilder_Two {
    public static void main(String[] args) {
        /**
         * 重叠构造器模式的缺点：当有许多参数的时候，客户端代码会很难编写，并且较难阅读。
         *      会导致一些微妙的错误，比如不小心颠倒了两个参数
         */
        new Vector<>();
        /**
         * 重叠构造器模式缺点的弥补方法：利用set方法来初始化成员变量。
         *      但是这样的话就可能出现线程不安全的问题，需要做其他的处理
         *
         * 解决上述问题可以使用构建器（Builder）模式
         */
        Dog.Builder builder = new Dog.Builder("阿黄", "yellow");
        builder.character("stupid").favorite("eat shit");
        Dog dog = builder.builder();
        System.out.println(dog);
        /**
         * 构建器（Builder）模式的缺点：
         *      必须要先创建构建器，在注重性能的情况下，可能会出现问题
         *      比重叠构造器更加冗长
         */
    }
}

class Dog {
    private final String name;
    private final String color;
    private final String character;
    private final String favorite;

    private Dog(Builder builder) {
        this.name = builder.name;
        this.color = builder.color;
        this.character = builder.character;
        this.favorite = builder.favorite;
    }

    public static class Builder { //构建器
        private final String name;
        private final String color;
        private String character = "haose";
        private String favorite = "mugou";

        public Builder(String name, String color) {
            this.name = name;
            this.color = color;
        }

        public Builder character(String val) {
            this.character = val;
            return this;
        }

        public Builder favorite(String val) {
            this.favorite = val;
            return this;
        }

        public Dog builder() {
            return new Dog(this);
        }
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", character='" + character + '\'' +
                ", favorite='" + favorite + '\'' +
                '}';
    }
}
