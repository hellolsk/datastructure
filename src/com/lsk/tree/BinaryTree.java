package com.lsk.tree;

/**
 * @Author:${六月的雨}
 * @Date:2020/7/18 16:22
 * @Description:20data_structure com.lsk.tree
 */

/**
 * 定义二叉树
 */
public class BinaryTree {

    private MyNode root;

    public MyNode getRoot() {
        return root;
    }

    public void setRoot(MyNode root) {
        this.root = root;
    }

    /**
     * 先序遍历
     */
    public void preTraverse() {
        if (root != null) {
            root.preTraverse();
        } else {
            System.out.println("二叉树为空！无法遍历！");
        }
    }

    /**
     * 中序遍历
     */
    public void inOrderTraverse() {
        if (root != null) {
            root.InOrderTraverse();
        } else {
            System.out.println("二叉树为空！无法遍历！");
        }
    }

    /**
     * 后序遍历
     */
    public void postTraverse() {
        if (root != null) {
            root.postTraverse();
        } else {
            System.out.println("二叉树为空！无法遍历！");
        }
    }

    /**
     * 前序查找
     *
     * @param no
     * @return
     */
    public MyNode preFind(int no) {
        if (root != null) {
            return root.preFind(no);
        } else {
            return null;
        }
    }

    /**
     * 中序查找
     *
     * @param no
     * @return
     */
    public MyNode inOrderFind(int no) {
        if (root != null) {
            return root.inOrderFind(no);
        } else {
            return null;
        }
    }

    /**
     * 前序查找
     *
     * @param no
     * @return
     */
    public MyNode postFind(int no) {
        if (root != null) {
            return root.postFind(no);
        } else {
            return null;
        }
    }

    /**
     * 删除结点
     * @param no
     */
    public void deleteNode(int no) {
        if (root != null) {
            //如果当前结点为待删除结点，直接删除
            if (root.getNo() == no) {
                root=null;
                return;
            }
            root.deleteNode(no);
        }else {
            System.out.println("二叉树为空！不能删除！");
        }
    }

}
