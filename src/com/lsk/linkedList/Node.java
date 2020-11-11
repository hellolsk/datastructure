package com.lsk.linkedList;

/**
 * 结点的实现
 * @Author:${六月的雨}
 * @Date:2020/6/25 17:56
 * @Description:20data_structure com.lsk.linkedList
 */
public class Node {
     public int data;
     public Node next;

     public Node() {
     }

     public Node(int data, Node next) {
          this.data = data;
          this.next = next;
     }

     @Override
     public String toString() {
          return "Node{" +
                  "data=" + data +
                  ", next=" + next +
                  '}';
     }
}
