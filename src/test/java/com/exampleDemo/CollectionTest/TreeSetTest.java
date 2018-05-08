package com.exampleDemo.CollectionTest;

import java.util.TreeSet;

/**
 * Created by ChenMP on 2018/3/27.
 */
public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<Person> treeSet = new TreeSet<>();
        treeSet.add(new Person("王五", 43));
        treeSet.add(new Person("张三", 23));
        treeSet.add(new Person("周七", 13));
        treeSet.add(new Person("赵六", 33));
        treeSet.add(new Person("李四", 13));

        System.out.println(treeSet);
    }
}
