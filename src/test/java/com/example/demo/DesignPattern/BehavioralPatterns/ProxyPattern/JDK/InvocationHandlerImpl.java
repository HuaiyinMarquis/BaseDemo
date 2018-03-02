package com.example.demo.DesignPattern.BehavioralPatterns.ProxyPattern.JDK;

import com.example.demo.DesignPattern.BehavioralPatterns.ProxyPattern.JDK.pojo.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by ChenMP on 2018/1/9.
 */
public class InvocationHandlerImpl implements InvocationHandler {
    private Person target;


    public Object getInstance(Person target) {
        this.target = target;
        Class clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("==========Method " + method.getName() + "() Before==========");
            Object result = method.invoke(target, args);
            System.out.println("==========Method " + method.getName() + "() After==========");
        return result;
    }
}
