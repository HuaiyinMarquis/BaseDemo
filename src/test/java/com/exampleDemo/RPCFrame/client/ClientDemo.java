package com.exampleDemo.RPCFrame.client;

import com.exampleDemo.RPCFrame.IHelloService;
import com.exampleDemo.RPCFrame.IServiceDiscover;

public class ClientDemo {
    public static void main(String[] args) {
        IServiceDiscover serviceDiscover = new ZKServiceDiscover();
        IHelloService helloService = new RPCClientProxy(serviceDiscover).clientProxy(IHelloService.class);
        System.out.println(helloService.sayHello("Huaiyinmarquis"));
    }
}
