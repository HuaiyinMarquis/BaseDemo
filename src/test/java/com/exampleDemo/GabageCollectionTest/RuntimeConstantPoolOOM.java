package com.exampleDemo.GabageCollectionTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChenMP on 2017/12/1.
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        //使用list保持引用，避免Full GC回收（JDK1.7以前有效）
        //-Dfile.encoding=UTF-8 -verbose:gc -XX:PermSize=10M -XX:MaxPermSize=10M -XX:+PrintGCDetails
//        List<String> list = new ArrayList<>();
//        int i = 0;
//        while(true) {
//            list.add(String.valueOf(i++).intern());
//        }

        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);

        String str3 = new StringBuilder("A").append("B").toString();
        System.out.println(str3.intern() == str3);

        String str4 = new StringBuilder("C").append("D").toString();
        System.out.println(str4.intern() == str4);
    }
}
