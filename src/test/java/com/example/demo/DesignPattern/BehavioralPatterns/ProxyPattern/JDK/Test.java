package com.example.demo.DesignPattern.BehavioralPatterns.ProxyPattern.JDK;

import com.example.demo.DesignPattern.BehavioralPatterns.ProxyPattern.JDK.pojo.Chinese;
import com.example.demo.DesignPattern.BehavioralPatterns.ProxyPattern.JDK.pojo.Person;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * Created by ChenMP on 2018/1/9.
 *原理：
 *  利用JDK做动态代理，实现类必须要有接口
 *  先拿被代理对象的接口，利用对象引用重新动态生成字节码
 */
public class Test {
    public static void main(String[] args) throws Exception{
        Person person = new Chinese();
        Person proxy = (Person) new InvocationHandlerImpl().getInstance(person);
        System.out.println("Chinese Class = " + person.getClass());
        System.out.println("Proxy Class = " + proxy.getClass());
        proxy.run();

        //从内存里面获取$Proxy0打印字节码文件
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
        FileOutputStream os = new FileOutputStream("C:\\Users\\ChenMP\\Desktop\\$Proxy0.class");
        os.write(bytes);
        os.close();
    }
}
