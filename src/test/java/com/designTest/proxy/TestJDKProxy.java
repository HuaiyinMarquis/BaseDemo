package com.designTest.proxy;

/**
 * Created by ChenMP on 2018/3/17.
 */
public class TestJDKProxy {
    public static void main(String[] args) {
        Person person = new JDKProxy(new Chinese()).getProxy();
//        person.eat();
        person.go();
    }
}
