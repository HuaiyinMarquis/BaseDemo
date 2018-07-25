package com.exampleDemo.RPCFrame.server;

import com.exampleDemo.RPCFrame.IHelloService;

/**
 * 设计思想：仿照RMI的实现方式对Server和Client进行设计
 */
public class ServerDemo {
    public static void main(String[] args) {
        IHelloService helloService = new HelloServiceImpl();
        new RPCService().publisher(helloService,9999);
    }
}
