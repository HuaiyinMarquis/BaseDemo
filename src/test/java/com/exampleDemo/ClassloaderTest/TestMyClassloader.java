package com.exampleDemo.ClassloaderTest;

/**
 * 验证不同的类加载器在相同场景下不一样的效果
 * Created by ChenMP on 2018/3/12.
 */
public class TestMyClassloader {
    public static void main(String[] args) {
        MyClassloader oneClassloader = new MyClassloader("D:\\","oneClassloader"); //这里调用的是App Classloader 获取的是classPath下面的Demo.class
        MyClassloader twoClassloader = new MyClassloader(null,"D:\\","twoClassloader"); //这里调用的事BootStrap Classloader 获取的是自定义路径下面的Demo.class
        try {
            Class<?> clazz = twoClassloader.loadClass("com.exampleDemo.ClassloaderTest.Demo");
            clazz.newInstance();
            System.out.println(clazz.getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
