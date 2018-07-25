package com.exampleDemo.RPCFrame.client;

import com.exampleDemo.RPCFrame.IHelloService;

public class ClientDemo {
    public static void main(String[] args) {
        IHelloService helloService = new RPCClientProxy().clientProxy(IHelloService.class,"localhost",9999);
        System.out.println(helloService.sayHello("Huaiyinmarquis"));
    }
}
