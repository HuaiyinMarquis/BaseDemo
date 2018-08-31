package com.exampleDemo;

import java.util.*;

/**
 * Created by ChenMP on 2018/3/27.
 */
public class TestBase {
    public static void main(String[] args) {
        List li;
        StringBuilder stringBuilder;
        StringBuffer stringBuffer;
//        for (;;){
//            System.out.println("1");
//        }
        String[] strs = new String[0];
        System.out.println(strs.length);
        /**
         * 分析HashMap源码（基于1.8）
         * 一、this.loadFactor = DEFAULT_LOAD_FACTOR = 0.75f; 设置默认加载因子
         * 二、 return putVal(hash(key), key, value, false, true);
         *      V putVal(int hash, K key, V value, boolean onlyIfAbsent,boolean evict)
         *      --n = (tab = resize()).length;
         *          --final Node<K,V>[] resize()
         */
        HashMap map = new HashMap();
        map.put(1,1);
        map.put(null,2);
        System.out.println(map.get(null));
        map.put(null,null);
        System.out.println(map.get(null));
        TreeMap treeMap = new TreeMap();
        treeMap.put(2,2);
        treeMap.put(1,1);
        System.out.println(treeMap.firstKey());
    }
}
