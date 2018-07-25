package com.exampleDemo.RPCFrame.server;

import com.exampleDemo.RPCFrame.IHelloService;
import com.exampleDemo.RPCFrame.IRegisterCenter;

import java.io.IOException;

/**
 * 设计思想：仿照RMI的实现方式对Server和Client进行设计
 */
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        IHelloService helloService = new HelloServiceImpl();
        IRegisterCenter registerCenter = new ZKRegisterCenter();
        new RPCService(registerCenter,"127.0.0.1:8080")
                .bind(helloService).publisher();
        System.in.read();
    }
}
