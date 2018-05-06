package com.chackoutDemo;

/**
 * Created by ChenMP on 2018/4/6.
 */
public class TestString {
    public static void main(String[] args) {
        String a = new String("A");
        String b = new String("B");
        System.out.println(a == a.intern());
    }
}
