package com.example.demo.ArithmeticTest.TestReversal;

//二叉树结点类
public class BiTreeNode {

    private BiTreeNode leftChild; // 左孩子
    private BiTreeNode rightChild; // 右孩子
    private Object data; // 数据元素

    BiTreeNode() {
        this.leftChild = null;
        this.rightChild = null;
    }

    BiTreeNode(Object data,BiTreeNode leftNode,BiTreeNode rightNode)
    {
        this.data = data;
        this.leftChild = leftNode;
        this.rightChild = rightNode;
    }


    public BiTreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BiTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public BiTreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BiTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
