package com.example.demo.ClassloaderTest;

/**
 * Created by ChenMP on 2018/3/12.
 */
public class GetClassloader {
    public static void main(String[] args) {
        ClassLoader classLoader = GetClassloader.class.getClassLoader();
        while (classLoader != null) {
            System.out.println(classLoader);
            classLoader = classLoader.getParent();
        }
    }
}
