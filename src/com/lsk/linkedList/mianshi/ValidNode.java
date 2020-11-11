package com.lsk.linkedList.mianshi;

import com.lsk.linkedList.MyNode;
import com.lsk.linkedList.Node;

/**
 * 求单链表中有效结点的个数
 * @Author:${六月的雨}
 * @Date:2020/6/26 09:11
 * @Description:20data_structure com.lsk.linkedList.mianshi
 */
public class ValidNode {
    public static int findValidNode(MyNode headNode){
        int count = 0;
        Node temp = headNode.next;
        while(temp.next!=null){
            if(temp.data!=0){
                count++;
            }
            temp = temp.next;
        }
        return count;
    }
}
