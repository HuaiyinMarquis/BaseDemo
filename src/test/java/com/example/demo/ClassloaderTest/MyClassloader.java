package com.example.demo.ClassloaderTest;

import java.io.*;

/**
 * Created by ChenMP on 2018/3/12.
 */
public class MyClassloader extends ClassLoader {

    private String path; //加载类的路径
    private String classloaderName; //加载器的名称

    public MyClassloader(String path, String classloaderName) {
        super();//SystemClassLoader() 指定父加载器为系统加载器
        this.path = path;
        this.classloaderName = classloaderName;
    }

    public MyClassloader(ClassLoader parent, String path, String classloaderName) {
        super(parent); //显示指定父加载器
        this.path = path;
        this.classloaderName = classloaderName;
    }

    //通过自定义的classloader加载自己的类
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = readClassFileToByteArray(name);
        return this.defineClass(name,data,0,data.length);
    }

    /**
     * 读取class文件转化为二进制数组
     * @param name
     * @return
     */
    private byte[] readClassFileToByteArray(String name) {
        InputStream inputStream = null;
        byte[] data = null;

        name = name.replaceAll("\\.","\\\\");
        String filePath = this.path + name + ".class";
        File file = new File(filePath);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            inputStream = new FileInputStream(file);
            int tmp = 0;
            while ((tmp = inputStream.read()) != -1) {
                outputStream.write(tmp);
            }
            data = outputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
                try {
                    if (null != outputStream)
                        outputStream.close();
                    if (null != inputStream)
                        inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

        return data;
    }

    @Override
    public String toString() {
        return this.classloaderName;
    }
}
