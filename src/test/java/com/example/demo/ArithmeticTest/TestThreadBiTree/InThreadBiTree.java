package com.example.demo.ArithmeticTest.TestThreadBiTree;

/**
 * 中序线索二叉树类
 * Created by ChenMP on 2018/3/21.
 */
public class InThreadBiTree extends ThreadBiTree {
    public InThreadBiTree() {
        super();
    }

    @Override
    public void initBiTree() {
        // TODO Auto-generated method stub
        super.initBiTree();
    }

    @Override
    public void createThreadBiTree() {

        create(head,null);
    }

    //中序线索化二叉树
    private BiTreeNode create(BiTreeNode curNode, BiTreeNode preNode) {
        if (curNode != null) {
            BiTreeNode tempNode = create(curNode.getLeftNode(), preNode); //获取最左叶节点 // A 、B  null

            if ((!curNode.getLeftFlag()) && (curNode.getLeftNode() == null)) //设置左节点线索化
            {
                curNode.setLeftFlag(true);
                curNode.setLeftNode(preNode);
            } // end of if

            preNode = tempNode;

            if ((preNode != null) && (preNode.getRightNode() == null))  //设置右节点线索化
            {
                preNode.setRightFlag(true);
                preNode.setRightNode(curNode);
            } // end of if

            preNode = curNode;
            preNode = create(curNode.getRightNode(), preNode); //
            return preNode;
        } // end of if

        return preNode;
    }

    //中序线索遍历算法
    @Override
    public void traversal() {
        BiTreeNode walker = this.head;

        if (this.head != null) {
            while (!walker.getLeftFlag())  //当LeftFlag为false时，获取到当前节点中序下最左叶子节点
                walker = walker.getLeftNode();

            System.out.print(walker.getData() + " ");

            while (walker.getRightNode() != null) { //当右节点不为空的时候
                if (walker.getRightFlag()) //当rightFlag为true的时候，获取右子节点
                    walker = walker.getRightNode();
                else { //当rightFlag为false的时候，获取右子节点
                    walker = walker.getRightNode();
                    while ((walker.getLeftNode() != null) && (!walker.getLeftFlag()))//当右子节点不为空且LeftFlag为false时，获取右子节点中序下最左叶子节点
                        walker = walker.getLeftNode();
                } // end of else

                System.out.print(walker.getData() + " ");
            } // end of while
        } // end of if
    }
}
