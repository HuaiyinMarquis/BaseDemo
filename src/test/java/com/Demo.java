package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node {
    public Node left;
    public Node right;
    public String value;

    public Node(String value) {
        this.value = value;
    }
}

/**
 * 最近两道面试题的答案：
 * 1、层序遍历二叉树
 * 2、找到随机两个节点的公共“父”节点，并打印出根节点到“父”节点的路径
 */
public class Demo {
    static int nowTier =0; //层级
    static List<Node> currentList = new ArrayList();
    static List<Node> sonList = new ArrayList();

    public static void getPath(Node root,Node nodeA,Node nodeB) {
        List<Node> chainA = new ArrayList();
        List<Node> chainB = new ArrayList();
        if (recForPath(root,nodeA,chainA) || recForPath(root,nodeB,chainB))
            System.out.println("二叉树中不存在相应结点");
        //找出最近的公共节点
        Stack<Node> stack = new Stack<>();
        boolean tag = false;//标识循环中断
        for (Node nodeP : chainA) {
            if (tag) break ;
            for (Node nodeS : chainB) {
                if (nodeP == nodeS) {
                    if (!tag)
                        System.out.println("最近的公共节点为：" + nodeP);
                    tag = true;
                }
                if (tag)
                    stack.push(nodeS);
            }
        }
        System.out.println("输出从根到该公共祖先节点的路径:");
        while (!stack.empty()) System.out.println(stack.pop() + "->");
    }

    public static boolean recForPath(Node root,Node compNode,List<Node> chain) {
        if (root.value.equals(compNode.value)) {
            chain.add(root);
            return true;
        } else {
            if (root.left != null) {
                if (recForPath(root.left,compNode,chain)) {
                    chain.add(root);
                    return true;
                } else
                    return false;
            }
            if (root.right != null) {
                if (recForPath(root.right,compNode,chain)) {
                    chain.add(root);
                    return true;
                } else
                    return false;
            }
            return false;
        }
    }

    public static void rec(Node root) {
        if (root != null) {
            currentList.add(root);
            nowTier++;
            go();
        }
    }

    public static void go() {
        if (currentList.size() == 0) return;
        for (Node node : currentList) {
            System.out.print(node.value);

            if (node.left != null) sonList.add(node.left);
            if (node.right != null) sonList.add(node.right);
        }
        System.out.print("\n");
        nowTier++;
        currentList = sonList;
        sonList = new ArrayList();
        go();
    }

    public static void main(String[] args) {
        Node root = new Node("1");
        root.left = new Node("2");
        root.right = new Node("3");
        root.left.left = new Node("4");
        root.left.right = new Node("5");
        root.right.left = new Node("6");
        root.right.right = new Node("7");
        root.left.left.left  = new Node("8");
        root.left.left.right = new Node("9");
        root.left.right.left  = new Node("10");
        root.left.right.right = new Node("11");
        root.right.left.left = new Node("12");
        root.right.left.right = new Node("13");
        root.right.right.left = new Node("14");
        root.right.right.right = new Node("15");
        rec(root);
    }
}
