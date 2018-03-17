package com.example.demo.ClassloaderTest;

/**
 * Created by ChenMP on 2018/3/12.
 */
public class Demo {
    public Demo() {
        System.out.println("Demo Init....");
    }

    public static void main(String[] args) {
        String str = "D:\\com.example.demo.ClassloaderTest.Demo.class ";
        System.out.println(str.replaceAll("\\.","\\\\"));
    }
}
