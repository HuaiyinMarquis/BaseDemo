package com.example.demo.DesignPattern.BehavioralPatterns.ProxyPattern.gclib;

import org.assertj.core.internal.cglib.proxy.Enhancer;
import org.assertj.core.internal.cglib.proxy.MethodInterceptor;
import org.assertj.core.internal.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by ChenMP on 2018/1/10.
 */
public class CarProxy implements MethodInterceptor {

    public Object getInstance(Object obj) throws Exception {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("method start");
        methodProxy.invokeSuper(obj,args);
        System.out.println("method end");
        return null;
    }
}
