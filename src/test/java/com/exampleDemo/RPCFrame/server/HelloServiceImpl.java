package com.exampleDemo.RPCFrame.server;

import com.exampleDemo.RPCFrame.IHelloService;
import com.exampleDemo.RPCFrame.anno.RPCAnnotation;

@RPCAnnotation(IHelloService.class)
public class HelloServiceImpl implements IHelloService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
