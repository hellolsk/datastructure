package com.lsk.linkedList.mianshi;

import com.lsk.linkedList.MyNode;

/**
 * 链表的翻转:
 * 思路：1，遍历依次取出每一个结点，
 *      2，将当前结点的后一个结点添加到反转链表的头结点处，保证是逆序的；
 *      3，将前一结点指向反转结点，即上一结点
 *      4，当前结点后移，重复此过程直到结点为空
 * @Author:${六月的雨}
 * @Date:2020/6/26 17:52
 * @Description:20data_structure com.lsk.linkedList.mianshi
 */
public class ReverseLinkedList {
    public static void reverseLinkedList(MyNode headNode){
        if(headNode.next==null || headNode.next.next==null){
            return;
        }
        //当前结点
        MyNode cur = (MyNode) headNode.next;
        //记录当前结点的下一个结点
        MyNode next = null;
        MyNode reverseHead = new MyNode(0,"","");
        while(null != cur){
            next = (MyNode) cur.next;//记录下一个结点
            cur.next = reverseHead.next;//将下一个结点置于反转链表的首部
            reverseHead.next = cur;//将当前结点挂载到新添加结点的后面
            cur = next;//结点后移
        }
        //最后将头结点指向反转结点
        headNode.next = reverseHead.next;
    }

    /**
     * 利用递归调用实现反转
     * @param headNode
     * @return
     */
    public static MyNode reverse(MyNode headNode){
        if(headNode==null || headNode.next==null){
            return headNode;
        }
        MyNode temp = (MyNode) headNode.next;
        MyNode reverseNode = reverse((MyNode) headNode.next);
        temp.next = headNode;//调整指针指向
        headNode.next = null;//将自己指向空
        return reverseNode;
    }
}
