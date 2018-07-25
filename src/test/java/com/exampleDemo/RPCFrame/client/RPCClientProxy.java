package com.exampleDemo.RPCFrame.client;

import com.exampleDemo.RPCFrame.IServiceDiscover;

import java.lang.reflect.Proxy;

/**
 * 创建代理
 */
public class RPCClientProxy {
    private IServiceDiscover serviceDiscover;

    public RPCClientProxy(IServiceDiscover serviceDiscover) {
        this.serviceDiscover = serviceDiscover;
    }

    public <T> T clientProxy(Class<T> clazz){
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(),new Class[]{clazz},new ClientInvocationHandler(serviceDiscover));
    }
}
