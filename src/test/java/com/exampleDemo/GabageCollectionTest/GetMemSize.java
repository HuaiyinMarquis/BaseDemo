package com.exampleDemo.GabageCollectionTest;

import java.util.ArrayList;
import java.util.List;

public class GetMemSize {
    public static void main(String[] args) {
        /****************************获取虚拟机内存大小****************************/
        System.out.println("maxMemory ->" + Runtime.getRuntime().maxMemory());
        System.out.println("totalMemory -> " + Runtime.getRuntime().totalMemory());
        System.out.println("freeMemory -> " + Runtime.getRuntime().freeMemory());
        /****************************测试常量池位置****************************/
        String s1 = new StringBuilder("水").append("bei").toString();
        System.out.println(s1.hashCode());
        System.out.println(s1.intern().hashCode());
        /****************************测试常量池内存溢出****************************/
        System.out.println(Integer.MAX_VALUE);
        List<String> list = new ArrayList<>();
        int i = 1;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
