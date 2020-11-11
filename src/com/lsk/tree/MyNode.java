package com.lsk.tree;

/**
 * @Author:${六月的雨}
 * @Date:2020/7/18 16:20
 * @Description:20data_structure com.lsk.tree
 */

/**
 * 自定义结点类,存放英雄
 */
public class MyNode {
    private int no;
    private MyNode left;
    private MyNode right;
    private String name;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public MyNode getLeft() {
        return left;
    }

    public void setLeft(MyNode left) {
        this.left = left;
    }

    public MyNode getRight() {
        return right;
    }

    public void setRight(MyNode right) {
        this.right = right;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 先序遍历
     */
    public void preTraverse(){
        //先输出当前结点
        System.out.println(this);
        //递归遍历左子树
        if(this.getLeft()!=null){
            this.left.preTraverse();
        }
        //递归遍历右子树
        if(this.getRight()!=null){
            this.right.preTraverse();
        }
    }

    /**
     * 中序遍历
     */
    public void InOrderTraverse(){
        //递归遍历左子树
        if(this.getLeft()!=null){
            this.left.InOrderTraverse();
        }
        System.out.println(this);
        //递归遍历右子树
        if(this.getRight()!=null){
            this.right.InOrderTraverse();
        }
    }
    /**
     * 后序遍历
     */
    public void postTraverse(){
        if(this.getRight()!=null){
            this.right.postTraverse();
        }
        if(this.getLeft()!=null){
            this.left.postTraverse();
        }
        System.out.println(this);
    }

    /**
     * 前序查找指定结点
     * @param no
     * @return
     */
    static int count = 0;
    public MyNode preFind(int no){
        count++;
        System.out.println("调用次数"+count);
        if(this.no==no){
            return this;
        }
        MyNode node = null;
        //递归遍历左子树
        if(this.left!=null){
             node = this.left.preFind(no);
        }
        //左遍历结束后，查看是否找到,不为空即找到
        if(node!=null){
            return node;
        }
        //否则右序遍历
        if(this.right!=null){
            node = this.right.preFind(no);
        }
       return node;
    }
    /**
     * 中序查找指定结点
     * @param no
     * @return
     */
    public MyNode inOrderFind(int no){
        count++;
        System.out.println("调用次数"+count);
        MyNode node = null;
        //递归遍历左子树
        if(this.left!=null){
            node = this.left.inOrderFind(no);
        }
        //左遍历结束后，查看是否找到,不为空即找到
        if(node!=null){
            return node;
        }
        if(this.no==no){
            return this;
        }
        //否则右序遍历
        if(this.right!=null){
            node = this.right.inOrderFind(no);
        }
        return node;
    }
    /**
     * 后序查找指定结点
     * @param no
     * @return
     */
    public MyNode postFind(int no){
        count++;
        System.out.println("调用次数"+count);
        MyNode node = null;
        //递归遍历右子树
        if(this.right!=null){
            node = this.right.postFind(no);
        }
        //右遍历结束后，查看是否找到,不为空即找到
        if(node!=null){
            return node;
        }
        //否则左序遍历
        if(this.left!=null){
            node = this.left.postFind(no);
        }
        if(node!=null){
            return node;
        }
        if(this.no==no){
            return this;
        }
        return node;
    }

    /**
     * 删除结点
     * 思路：找到当前结点的子结点是否为需要删除结点，是，直接置空，否则，向左递归删除，然后向右递归
     * @param no
     */
    public void deleteNode(int no){
        if(this.left!=null && this.left.no==no){
            this.left=null;
            return;
        }
        if(this.right!=null&& this.right.no==no){
            this.right=null;
            return;
        }
        if(this.left!= null){
            this.left.deleteNode(no);
        }
        if(this.right!= null){
            this.right.deleteNode(no);
        }
    }
}
