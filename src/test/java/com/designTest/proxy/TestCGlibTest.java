package com.designTest.proxy;

/**
 * Created by ChenMP on 2018/3/18.
 */
public class TestCGlibTest {
    public static void main(String[] args) {
        Chinese proxy = (Chinese) new CGLibProxy(new Chinese()).getProxy();
//        proxy.eat();
        proxy.go();
    }
}
