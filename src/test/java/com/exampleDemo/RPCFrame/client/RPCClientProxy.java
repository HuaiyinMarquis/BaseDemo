package com.exampleDemo.RPCFrame.client;

import java.lang.reflect.Proxy;

/**
 * 创建代理
 */
public class RPCClientProxy {
    public <T> T clientProxy(Class<T> clazz, String ip, int port){
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(),new Class[]{clazz},new ClientInvocationHandler(ip,port));
    }
}
