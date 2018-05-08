package com.exampleDemo.ArithmeticTest.TestThreadBiTree;

import java.util.Scanner;

/**
 * 线索二叉树类
 * Created by ChenMP on 2018/3/21.
 */
public class ThreadBiTree {
    protected BiTreeNode head;
    protected final static String ENDFLAG = "null";

    public ThreadBiTree() {
        this.head = null;
    }

    //初始化二叉树的根节点
    public void initBiTree() {
        String item;
        Scanner in = new Scanner(System.in);
        System.out.println("请输入二叉树的树根结点（输入null表示该结点为空）：");
        item = in.next();
        if (!item.equalsIgnoreCase(ENDFLAG)) {
            head = new BiTreeNode(item);
            init(head);
        }
    }

    //初始化二叉树
    private void init(BiTreeNode head) {
        String item;
        Scanner in = new Scanner(System.in);
        System.out.println("请输入"+head.getData()+"结点的左孩子结点：");
        item = in.next();
        if (!item.equalsIgnoreCase(ENDFLAG)) {
            head.setLeftNode(new BiTreeNode(item));
            init(head.getLeftNode()); //递归
        }
        System.out.println("请输入"+head.getData()+"结点的右孩子结点：");
        item = in.next();
        if (!item.equalsIgnoreCase(ENDFLAG)) {
            head.setRightNode(new BiTreeNode(item));
            init(head.getRightNode()); //递归
        }
    }

    //创建线索二叉树
    public void createThreadBiTree() {

    }

    //线索遍历算法
    public void traversal() {

    }
}
