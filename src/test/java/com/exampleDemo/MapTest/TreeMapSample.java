package com.exampleDemo.MapTest;

import java.util.TreeMap;

public class TreeMapSample {
    public static void main(String[] args) {
        TreeMap<String,String> map = new TreeMap();
        map.put("k1","v1");
        map.put("k3","v3");
        map.put("k2","v2");
        map.forEach((k,v) -> {
            System.out.println("key_"+k+":value_"+v);
        });
        System.out.println(map.firstKey());
    }
}
