package com.homework.designTest.proxy.myself;

import java.lang.reflect.Method;

/**
 * Created by ChenMP on 2018/3/23.
 */
public interface MyInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
