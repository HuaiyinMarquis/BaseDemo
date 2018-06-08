package com.designTest.singleton;

/**
 * 类的初始化阶段是执行类构造器<clinit>() 方法的过程。
 * <clinit>() 方法是由编译器自动收集类中的所有类变量（static）的赋值动作和静态语句块（static{}）块中的语句合并产生的。
 * 因为外部类初始化不会引发静态内部类SingletonHolder的初始化，所以只有真正调用getInstance()方法，执行 SingletonHolder.INSTANCE 时，
 * 才会引发静态内部类初始化，从而完成实例化。所以，静态内部类实现是延迟加载的。
 * 内部类实现，线程安全
 * Created by ChenMP on 2018/3/17.
 */
public class Five {
    private Five() {}
    public Five getInstance() {
        return FiveHolder.five;
    }

    private static class FiveHolder {
        private static final Five five = new Five();
    }
}
