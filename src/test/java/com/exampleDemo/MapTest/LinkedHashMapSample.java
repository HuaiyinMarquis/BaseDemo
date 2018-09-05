package com.exampleDemo.MapTest;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 模拟一个空间占用敏感的资源池,可以自动将最不常用的对象释放掉
 */
public class LinkedHashMapSample {
    public static void main(String[] args) {
        LinkedHashMap<String, String> map = new LinkedHashMap(16,0.75F,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {//实现自定义的删除策略
                return size() > 3;
            }
        };
        map.put("k1","v1");
        map.put("k2","v2");
        map.put("k3","v3");
        map.forEach((k,v) -> {
            System.out.println("key_"+k+":value_"+v);
        });
        //模拟使用：证明get，put，compute方法都有效
        map.get("k1");
//        map.get("k2");
//        map.put("k2","v22");
        map.compute("k2",(k,v) -> {
            return k+v;
        });
        map.get("k3");
        System.out.println("Iterator over should be not affected:");
        map.forEach((k,v) -> {
            System.out.println("key_"+k+":value_"+v);
        });
        //触发删除
        map.put("k4","v4");
        System.out.println("Old entry should be removed:");
        map.forEach((k,v) -> {
            System.out.println("key_"+k+":value_"+v);
        });
    }
}
