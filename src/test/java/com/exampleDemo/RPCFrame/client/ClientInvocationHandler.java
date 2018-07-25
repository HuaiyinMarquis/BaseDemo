package com.exampleDemo.RPCFrame.client;

import com.exampleDemo.RPCFrame.IServiceDiscover;
import com.exampleDemo.RPCFrame.RPCRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ClientInvocationHandler implements InvocationHandler {
    private IServiceDiscover serviceDiscover;

    public ClientInvocationHandler(IServiceDiscover serviceDiscover) {
        this.serviceDiscover = serviceDiscover;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RPCRequest request = new RPCRequest();
        request.setClassName(method.getDeclaringClass().getName());
        request.setMethodName(method.getName());
        request.setParameters(args);

        String[] serviceAddrss = serviceDiscover.discover(request.getClassName()).split(":");
        return new TCPTransport().newSocket(serviceAddrss[0],Integer.parseInt(serviceAddrss[1])).send(request);
    }
}
