package com.homework.designTest.singleton;

/**
 * TODO 用自己的话解释清楚
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

