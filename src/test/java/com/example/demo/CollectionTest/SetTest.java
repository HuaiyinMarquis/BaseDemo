package com.example.demo.CollectionTest;

import java.util.AbstractSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by ChenMP on 2018/3/27.
 */
public class SetTest extends AbstractSet {
    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        System.out.println(map.put("a","b"));
    }
}
