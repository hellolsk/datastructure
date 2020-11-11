package com.lsk.linkedList;

/**
 * @Author:${六月的雨}
 * @Date:2020/6/29 14:55
 * @Description:20data_structure com.lsk.linkedList
 */
public class DoubleLinkedTest {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        MyDoubleNode myNode1 = new MyDoubleNode(1, "宋江", "及时雨");
        MyDoubleNode myNode2 = new MyDoubleNode(2, "吴用", "智多星");
        MyDoubleNode myNode3 = new MyDoubleNode(3, "卢俊义", "玉麒麟");
        doubleLinkedList.add(myNode1);
        doubleLinkedList.add(myNode2);
        doubleLinkedList.add(myNode3);
        doubleLinkedList.print();
        doubleLinkedList.delete(3);
        doubleLinkedList.print();
    }
}
