package com.exampleDemo.ClassloaderTest.DiffWithClassForName;

/**
 *  实验证明Class.forName加载类会执行类中static方法
 *  Classloader不会执行类中的static方法
 * Created by ChenMP on 2018/3/29.
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
//        testClassloader();
        testClassForName();
    }

    private static void testClassForName() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.example.demo.ClassloaderTest.DiffWithClassForName.JavaBean");
    }

    private static void testClassloader() throws ClassNotFoundException {
        Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass("com.example.demo.ClassloaderTest.DiffWithClassForName.JavaBean");
    }
}