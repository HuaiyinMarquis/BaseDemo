package com.designTest.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by ChenMP on 2018/3/17.
 */
public class JDKProxy implements InvocationHandler {
    private Person person;

    public JDKProxy(Person person) {
        this.person = person;
    }

    public Person getProxy() {
        Object obj = Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), this);
        return (Person) obj;
    }

    @Override
    public Object invoke(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("调用方法前的处理..............");
        Object result = method.invoke(person, args);
        System.out.println("调用方法后的处理..............");
        return result;
    }
}
