package com.lsk.linkedList.mianshi;

import com.lsk.linkedList.LinkedList;
import com.lsk.linkedList.MyNode;

/**
 * 查找单链表中指定的倒数第k个结点
 * @Author:${六月的雨}
 * @Date:2020/6/26 09:29
 * @Description:20data_structure com.lsk.linkedList.mianshi
 */
public class FindReciprocalNode {
  public static MyNode findReciprocalNode(MyNode headNode,int k){
      int length = LinkedList.size(headNode);
      if(k<=0 || k>=length){
          return null;
      }
      MyNode temp = (MyNode) headNode.next;
      for(int i = 1;i<=length-k;i++){
          temp = (MyNode) temp.next;
      }
      return temp;
  }
}
