package com.lsk.linkedList.mianshi;

import com.lsk.linkedList.LinkedList;
import com.lsk.linkedList.MyNode;

/**
 * @Author:${六月的雨}
 * @Date:2020/6/26 09:30
 * @Description:20data_structure com.lsk.linkedList.mianshi
 */
public class Test {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        MyNode node1 = new MyNode(1, "lsk", "梁世凯");
        MyNode node2 = new MyNode(2, "lsk", "");
        MyNode node3 = new MyNode(3, "", "梁世凯");
        linkedList.add(node1);
        linkedList.add(node2);
        linkedList.add(node3);
//        int i = ValidNode.findValidNode(linkedList.headNode);
//        System.out.println("有效结点个数为："+i);
//        MyNode reciprocalNode = FindReciprocalNode.findReciprocalNode(linkedList.headNode, 1);
//        System.out.println(reciprocalNode);
        //ReverseLinkedList.reverseLinkedList(linkedList.headNode);
        MyNode reverse = ReverseLinkedList.reverse(linkedList.headNode);
        while (reverse.next!=null){

            System.out.println(reverse.data);
            reverse = (MyNode) reverse.next;
        }
        //linkedList.print();
    }
}
