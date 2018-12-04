package com.exampleDemo.MapTest;

import java.util.LinkedHashMap;

public class LinkedHashMapSample {
    Short a;
    public static void main(String[] args) {
        LinkedHashMap map = new LinkedHashMap(10, 0.75f, true);
        map.put(2,22);
        map.put(1,11);
        map.put(4,44);
        map.put(3,33);
        map.forEach((k,v) -> {
            System.out.println("key:"+k+"->value:"+v);
        });
        System.out.println("-----------------------------------");
        map.get(4);
        map.put(2,"222");
        map.forEach((k,v) -> {
            System.out.println("key:"+k+"->value:"+v);
        });
    }
}
