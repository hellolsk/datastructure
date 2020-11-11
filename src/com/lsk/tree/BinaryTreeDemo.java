package com.lsk.tree;

/**
 * @Author:${六月的雨}
 * @Date:2020/7/18 10:22
 * @Description:20data_structure com.lsk.tree
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        MyNode root = new MyNode(1,"唐僧");
        MyNode MyNode1 = new MyNode(2,"孙悟空");
        MyNode MyNode2 = new MyNode(3,"猪八戒");
        MyNode MyNode3 = new MyNode(4,"沙僧");
        MyNode MyNode4 = new MyNode(5,"白龙马");
        //手动添加结点到二叉树
        root.setLeft(MyNode1);
        root.setRight(MyNode2);
        MyNode2.setRight(MyNode3);
        MyNode3.setRight(MyNode4);
        tree.setRoot(root);
        //遍历
//        tree.preTraverse();
//        tree.inOrderTraverse();
//        tree.postTraverse();
        MyNode MyNode = tree.inOrderFind(1);
        if(MyNode !=null){
            System.out.println("ok!"+ MyNode.toString());
        }else {
            System.out.println("no result!");
        }
        tree.deleteNode(1);
        tree.preTraverse();
    }
}


