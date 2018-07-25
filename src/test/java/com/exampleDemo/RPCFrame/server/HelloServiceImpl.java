package com.exampleDemo.RPCFrame.server;

import com.exampleDemo.RPCFrame.IHelloService;

public class HelloServiceImpl implements IHelloService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
