package com.homework.designTest.proxy;

import org.assertj.core.internal.cglib.proxy.Enhancer;
import org.assertj.core.internal.cglib.proxy.MethodInterceptor;
import org.assertj.core.internal.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by ChenMP on 2018/3/18.
 */
public class CGLibProxy implements MethodInterceptor {
    private Object obj;

    public CGLibProxy(Object obj) {
        this.obj = obj;
    }

    public Object getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用方法前的处理..............");
        Object result = method.invoke(obj, objects);
        System.out.println("调用方法后的处理..............");
        return result;
    }
}
