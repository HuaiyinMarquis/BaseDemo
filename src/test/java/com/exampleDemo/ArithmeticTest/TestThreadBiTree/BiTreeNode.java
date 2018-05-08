package com.exampleDemo.ArithmeticTest.TestThreadBiTree;

/**
 * 线索二叉树的节点类
 * Created by ChenMP on 2018/3/21.
 */
public class BiTreeNode {
    private BiTreeNode leftNode; //左孩子
    private BiTreeNode rightNode; //右孩子
    private Boolean leftFlag; //是否是左线索
    private Boolean rightFlag; //是否是右线索
    private Object data;

    public BiTreeNode() {
        this.leftNode = null;
        this.rightNode = null;
        this.leftFlag = false;
        this.rightFlag = false;
    }

    public BiTreeNode(Object data)
    {
        this();
        this.data = data;
    }

    public BiTreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BiTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public BiTreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BiTreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public Boolean getLeftFlag() {
        return leftFlag;
    }

    public void setLeftFlag(Boolean leftFlag) {
        this.leftFlag = leftFlag;
    }

    public Boolean getRightFlag() {
        return rightFlag;
    }

    public void setRightFlag(Boolean rightFlag) {
        this.rightFlag = rightFlag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
