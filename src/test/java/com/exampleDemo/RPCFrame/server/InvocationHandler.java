package com.exampleDemo.RPCFrame.server;


import com.exampleDemo.RPCFrame.RPCRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * 执行类
 */
public class InvocationHandler implements Runnable {
    private final Socket socket;
    private final Object service;

    public InvocationHandler(Socket socket,Object service) {
        this.socket = socket;
        this.service = service;
    }

    @Override
    public void run() {
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            RPCRequest request = (RPCRequest) objectInputStream.readObject();
            Object result = invoke(request);

            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(result);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectInputStream != null)
                    objectInputStream.close();
                if (objectOutputStream != null)
                    objectOutputStream.close();
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private Object invoke(RPCRequest request) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object[] args = request.getParameters();
        Class[] tyeps = new Class[args.length];
        for (int i=0;i<args.length;i++){
            tyeps[i] = args[i].getClass();
        }
        Method method = service.getClass().getMethod(request.getMethodName(),tyeps);
        return method.invoke(service,args);
    }
}
