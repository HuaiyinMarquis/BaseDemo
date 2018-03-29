package com.homework.designTest.prototype;

/**
 * Created by ChenMP on 2018/3/23.
 */
public class TestPrototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        int[] someThing = {1,2,3,4};
        OtherInApple otherInApple = new OtherInApple("other");
        Apple apple = new Apple("red",8, someThing,otherInApple);

        Apple clone = (Apple) apple.clone(); //浅克隆
        System.out.println(clone);  //数据一致
        System.out.println(apple == clone);// 内存地址不一致

        clone = apple.deepClone();
        System.out.println(clone);
        System.out.println(apple == clone);
    }
}
