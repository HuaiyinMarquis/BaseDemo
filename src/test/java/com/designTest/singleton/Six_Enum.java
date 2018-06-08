package com.designTest.singleton;

/**
 * subject：通过私有构造器或者枚举强化Singleton属性
 * 枚举类型只会加载一次，所以天生线程安全
 *  无偿的提供了序列化机制，即使在面对复杂的序列化或者反射攻击的时候也绝对防止多次实例化，
 * Created by ChenMP on 2018/3/17.
 */
public enum Six_Enum {
    OBJECTDATE;
    private SingletonObject singletonObject;
    private Six_Enum() {
        singletonObject = new SingletonObject();
    }
    public SingletonObject getInstance(){
        return singletonObject;
    }
}

