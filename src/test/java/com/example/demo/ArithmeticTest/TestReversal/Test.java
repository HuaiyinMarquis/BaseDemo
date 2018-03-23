package com.example.demo.ArithmeticTest.TestReversal;

/**
 * 普通二叉树打印及查找
 */
public class Test {
   
	public static BiTreeNode makeTree()
	{
		BiTreeNode b,c,d,e,f,g;
		g = BiTree.getTreeNode(new Character('G'), null, null);
		d = BiTree.getTreeNode(new Character('D'), null, g);
		b = BiTree.getTreeNode(new Character('B'), d, null);
		e = BiTree.getTreeNode(new Character('E'), null, null);
		f = BiTree.getTreeNode(new Character('F'), null, null);
	    c = BiTree.getTreeNode(new Character('C'), e, f);
	    return BiTree.getTreeNode(new Character('A'), b, c);
	}
	
	public static void main(String[] args) {
		
		BiTreeNode root;
		BiTreeNode temp;
		
		Visit visit = new Visit();
		
		root = Test.makeTree();
        System.out.println("二叉树为：");
		BiTree.printBiTree(root, 0);
		System.out.println();

        System.out.println("前序遍历的序列是：");
		Traverse.preOrder(root, visit);
		System.out.println();

        System.out.println("中序遍历的序列是：");
		Traverse.inOrder(root, visit);
		System.out.println();

        System.out.println("后序遍历的序列是：");
		Traverse.postOrder(root, visit);
		System.out.println();

        System.out.println("层次遍历的序列是：");
		Traverse.levOrder(root, visit);
		System.out.println();
		
	    temp = BiTree.search(root, new Character('D'));
	    if(temp!=null)
	    {
	    	System.out.println(temp.getData());
	    }
	    else
	    {
            System.out.println("没有找到指定元素！");
	    }

        //翻转二叉树
	    BiTree.reverse(root);
        System.out.println("翻转二叉树为：");
	    BiTree.printBiTree(root, 0);
	}

}
