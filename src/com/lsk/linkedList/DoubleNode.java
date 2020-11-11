package com.lsk.linkedList;

/**
 * 双向链表结点
 * @Author:${六月的雨}
 * @Date:2020/6/29 14:36
 * @Description:20data_structure com.lsk.linkedList
 */
public class DoubleNode {
    protected int data;
    protected DoubleNode pre;
    protected DoubleNode next;

    public DoubleNode(int data, DoubleNode pre, DoubleNode next) {
        this.data = data;
        this.pre = pre;
        this.next = next;
    }

    public DoubleNode() {
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "data=" + data +
                ", pre=" + pre +
                ", next=" + next +
                '}';
    }
}
