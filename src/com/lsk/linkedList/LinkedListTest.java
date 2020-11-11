package com.lsk.linkedList;

/**
 * @Author:${六月的雨}
 * @Date:2020/6/25 18:49
 * @Description:20data_structure com.lsk.linkedList
 */
public class LinkedListTest {
    public static void main(String[] args) {
        MyNode myNode1 = new MyNode(1, "宋江", "及时雨");
        MyNode myNode2 = new MyNode(2, "吴用", "智多星");
        MyNode myNode3 = new MyNode(3, "卢俊义", "玉麒麟");
        LinkedList linkedList = new LinkedList();
        linkedList.add(myNode1);
        linkedList.add(myNode2);
        linkedList.add(myNode3);
        linkedList.print();
        linkedList.delete(2);
        linkedList.print();
//      myNode2.setName("hh");
//      myNode2.setNickName("hhhhhh");
//      linkedList.update(myNode2);
//      linkedList.find(2);
        System.out.println(linkedList.size(linkedList.headNode));
    }
}
