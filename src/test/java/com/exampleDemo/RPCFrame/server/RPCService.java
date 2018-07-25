package com.exampleDemo.RPCFrame.server;

import com.exampleDemo.RPCFrame.IRegisterCenter;
import com.exampleDemo.RPCFrame.anno.RPCAnnotation;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RPCService {
    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    private IRegisterCenter registerCenter;
    private String serviceAddress;
    //存放服务名称与服务对象之间的关系
    Map<String,Object> handleMap = new HashMap<>();

    public RPCService(IRegisterCenter registerCenter, String serviceAddress) {
        this.registerCenter = registerCenter;
        this.serviceAddress = serviceAddress;
    }

    //绑定服务
    public RPCService bind(Object... services) {
        for (Object service:services) {
            RPCAnnotation annotation = service.getClass().getAnnotation(RPCAnnotation.class);
            String serviceName = annotation.value().getName();
            handleMap.put(serviceName,service);
        }
        return this;
    }

    //发布服务
    public void publisher(){
        ServerSocket serverSocket = null;
        try {
            String[] addres = serviceAddress.split(":");
            serverSocket = new ServerSocket(Integer.parseInt(addres[1]));

            //遍历所有需要注册的服务进行注册
            for (String interfaceName:handleMap.keySet()) {
                registerCenter.regiter(interfaceName,serviceAddress);
                System.out.println("注册服务成功:" + interfaceName + " -> " + serviceAddress);
            }

            while (true) {
                Socket socket = serverSocket.accept();
                executorService.submit(new InvocationHandler(socket,handleMap));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
