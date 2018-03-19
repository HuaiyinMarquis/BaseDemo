package com.example.demo.EnumTest;

/**
 * 接口组织枚举
 * Created by ChenMP on 2018/3/19.
 */
public interface InterfaceEnum {
    enum Food implements InterfaceEnum {
        BLACK_COFFEE,DECAF_COFFEE,LATTE,CAPPUCCINO
    }
    enum Desser implements InterfaceEnum {
        FRUIT, CAKE, GELATO
    }
}
