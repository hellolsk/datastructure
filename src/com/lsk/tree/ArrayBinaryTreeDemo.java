package com.lsk.tree;

/**
 * 使用数组存储二叉树
 * @Author:${六月的雨}
 * @Date:2020/11/8 21:34
 * @Description:20data_structure com.lsk.tree
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        arrayBinaryTree.preOrder();//1,2,4,5,3,6,7
    }
}
class ArrayBinaryTree{
    private int[] arr;
    public ArrayBinaryTree(int[] arr){
        this.arr = arr;
    }
    //重载方法，从0开始
    public void preOrder(){
        this.preOrder(0);
    }

    /**
     * 实现前序遍历顺序二叉树
     * @param index
     */
    public void preOrder(int index){
        if(null == arr || arr.length==0){
            System.out.println("数组为空，无法遍历！");
        }
        System.out.println(arr[index]);
        //左序递归遍历，索引是上一索引的2倍+1
        if(2*index+1<arr.length){
            preOrder(2*index+1);
        }
        //右序递归遍历，索引是上一索引的2倍+2
        if(2*index+2<arr.length){
            preOrder(2*index+2);
        }
    }
}
