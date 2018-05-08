package com.exampleDemo.ArithmeticTest.BiTreeSearch;


/**
 * 二叉树结点类
 *
 */

public class BiTreeNode{
    private BiTreeNode leftChild;
    private BiTreeNode rightChild;
    private BiTreeNode parent;
    private int data;

    public BiTreeNode(){
        leftChild = null;
        rightChild = null;
    }

    public BiTreeNode(int item){
        leftChild = null;
        rightChild = null;
        data = item;
    }

    public BiTreeNode(int item, BiTreeNode left, BiTreeNode right){
        data = item;
        leftChild = left;
        rightChild = right;
    }

    public void setParent(BiTreeNode parent){
        this.parent = parent;
    }

    public BiTreeNode getParent(){
        return parent;
    }

    public void setLeftChild(BiTreeNode left){
        leftChild = left;
    }

    public void setRightChild(BiTreeNode right){
        rightChild = right;
    }

    public void setData(int data){
        this.data = data;
    }

    public BiTreeNode getLeft(){
        return leftChild;
    }

    public BiTreeNode getRight(){
        return rightChild;
    }
    public int getData(){
        return data;
    }
}
