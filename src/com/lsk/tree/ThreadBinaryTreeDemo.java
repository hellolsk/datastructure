package com.lsk.tree;

public class ThreadBinaryTreeDemo {
    public static void main(String[] args) {

        ThreadedBinaryTree tree = new ThreadedBinaryTree();

        MyThreadedNode root= new MyThreadedNode(1,"a1");
        MyThreadedNode myThreadedNode1 = new MyThreadedNode(3,"a3");
        MyThreadedNode myThreadedNode2 = new MyThreadedNode(6,"a6");
        MyThreadedNode myThreadedNode3 = new MyThreadedNode(8,"a8");
        MyThreadedNode myThreadedNode4 = new MyThreadedNode(10,"a10");
        MyThreadedNode myThreadedNode5 = new MyThreadedNode(14,"a14");

        root.setLeft(myThreadedNode1);
        root.setRight(myThreadedNode2);
        myThreadedNode1.setLeft(myThreadedNode3);
        myThreadedNode1.setRight(myThreadedNode4);
        myThreadedNode2.setLeft(myThreadedNode5);

        //测试后序线索化二叉树，链接父节点
        myThreadedNode1.setParent(root);
        myThreadedNode2.setParent(root);
        myThreadedNode3.setParent(myThreadedNode1);
        myThreadedNode4.setParent(myThreadedNode1);
        myThreadedNode5.setParent(myThreadedNode2);

        tree.setRoot(root);
//        tree.threaded();
        //测试线索化是否成功
//        MyNode left = myNode4.getLeft();
//        MyNode right = myNode4.getRight();
//        System.out.println(right);
//        System.out.println(left);
//        tree.inOrder();
//        tree.preThreaded(root);
//        tree.threadedListPre();
//        MyThreadedNode left = myThreadedNode1.getLeft();
//        MyThreadedNode right = myThreadedNode1.getRight();
//        System.out.println(left);
//        System.out.println(right);
//        tree.threadedList();
        tree.postThreaded(root);
        tree.threadedListPost();
    }
}
