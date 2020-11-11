package com.lsk.linkedList;

/**
 * @Author:${六月的雨}
 * @Date:2020/6/29 14:44
 * @Description:20data_structure com.lsk.linkedList
 */
public class DoubleLinkedList {
    //初始化一个头结点
    private MyDoubleNode headNode = new MyDoubleNode(0,"","");

    /**
     * 在末尾处添加结点
     * @param myDoubleNode
     */
    public void add(MyDoubleNode myDoubleNode){
        MyDoubleNode temp = headNode;
        while (temp.next!=null){
            temp = (MyDoubleNode) temp.next;
        }
        //互指，形成双向链表
        temp.next = myDoubleNode;
        myDoubleNode.pre = temp;
    }

    /**
     * 找到待删除结点，直接删除
     * @param no
     */
    public void delete(int no){
        MyDoubleNode temp = (MyDoubleNode) headNode.next;
        boolean flag = false;
        if(temp==null){
            System.out.println("链表为空！");
            return;
        }
        while(true){
            if(temp==null){
               break;
            }
            if(temp.data==no){
                flag = true;
                break;
            }
            temp = (MyDoubleNode) temp.next;
        }
        if(flag){
            //将前一结点next指向后一结点
            temp.pre.next = temp.next;
            if(temp.next!=null){
                //将后一结点的pre指向前一结点,当然前提是后一结点存在，即删除的不是最后一个结点
                temp.next.pre = temp.pre;
            }
            System.out.println("删除成功！");
        }else{
            System.out.println("删除失败！");
        }

    }

    /**
     * 遍历链表
     */
    public void print(){
        if(headNode.next==null){
            System.out.println("链表为空！");
            return;
        }
        MyDoubleNode temp = (MyDoubleNode) headNode.next;
        while (temp!=null){
            System.out.println(temp);
            temp = (MyDoubleNode) temp.next;
        }
    }
}
