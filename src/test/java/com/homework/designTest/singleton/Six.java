package com.homework.designTest.singleton;

/**
 * 枚举类型只会加载一次，所以天生线程安全
 * Created by ChenMP on 2018/3/17.
 */
public enum Six {
    OBJECTDATE;
    private SingletonObject singletonObject;
    private Six() {
        singletonObject = new SingletonObject();
    }
    public SingletonObject getInstance(){
        return singletonObject;
    }
}

