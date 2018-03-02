package com.example.demo;

import java.util.*;

/**
 * Created by ChenMP on 2018/3/2.
 */
public class IteratorTest {
    public static void main(String[] args) {
        String[] strs = {"a","b","c","d","e","f","g","h"};
        List<String> list = Arrays.asList(strs);
        Set<String> set = new HashSet<>();
        set.addAll(list);
        System.out.println(set);
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String next = it.next();
            it.remove();
        }
        System.out.println(set);
    }
}
