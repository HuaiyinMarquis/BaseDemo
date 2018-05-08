package com.exampleDemo.ArithmeticTest.TestThreadBiTree;

/**
 * 中序遍历线索化
 * Created by ChenMP on 2018/3/21.
 */
public class Test {
    public static void main(String[] args) {

        ThreadBiTree tree = new InThreadBiTree();
        tree.initBiTree();
        tree.createThreadBiTree();
        System.out.println("中序遍历序列是：");
        tree.traversal();

    }
}
