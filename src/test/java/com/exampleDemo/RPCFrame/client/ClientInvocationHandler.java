package com.exampleDemo.RPCFrame.client;

import com.exampleDemo.RPCFrame.RPCRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ClientInvocationHandler implements InvocationHandler {
    private String ip;
    private int port;

    public ClientInvocationHandler(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RPCRequest request = new RPCRequest();
        request.setClassName(method.getDeclaringClass().getName());
        request.setMethodName(method.getName());
        request.setParameters(args);
        return new TCPTransport().newSocket(ip,port).send(request);
    }
}
