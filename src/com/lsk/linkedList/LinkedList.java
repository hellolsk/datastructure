package com.lsk.linkedList;

/**
 * 自定义单链表
 * @Author:${六月的雨}
 * @Date:2020/6/25 18:25
 * @Description:20data_structure com.lsk.linkedList
 */
public class LinkedList {
    //头结点
    public MyNode headNode = new MyNode(0,"","");

    /**
     * 添加结点到链表：在最后一个结点添加
     * @param myNode
     */
    public void add(MyNode myNode){
        MyNode temp = headNode;
        //找到最后一个结点
        while(temp.next!=null){
            temp = (MyNode) temp.next;
        }
        temp.next = myNode;
    }

    /**
     * 根据编号删除链表的结点信息
     * 找到待删除结点的前一个结点
     * @param no
     */
    public void delete(int no){
        MyNode temp = headNode;
        //标记是否找到
        boolean flag = false;
        //找到编号对应的结点
        while(true){
            if(temp.next==null){
                break;
            }
            if(temp.next.data==no){
               flag = true;
               break;
            }
            temp = (MyNode) temp.next;
        }
        if(flag){
            //将下一个结点指向当前结点的next域
            temp.next = temp.next.next;
            System.out.println("删除成功!");
        }else {
            System.out.printf("您要找的%d不存在，删除失败！\n",no);
        }
    }

    /**
     * 根据编号修改结点信息
     * @param newNode
     */
    public void update(MyNode newNode){
        MyNode temp = headNode;
        //标记是否找到
        boolean flag = false;
        //找到编号对应的结点
        while(true){
            if(temp.next==null){
                break;
            }
            if(temp.next.data==newNode.data){
                flag = true;
                break;
            }
            temp = (MyNode) temp.next;
        }
        if(flag){
            temp.name = newNode.name;
            temp.nickName = newNode.nickName;
        }else {
            System.out.printf("您要找的不存在，修改失败！\n");
        }
    }

    /**
     * 根据编号查询
     * @param no
     */
    public void find(int no){
        MyNode temp = headNode;
        //标记是否找到
        boolean flag = false;
        //找到编号对应的结点
        while(true){
            if(temp.next==null){
                break;
            }
            if(temp.next.data==no){
                flag = true;
                break;
            }
            temp = (MyNode) temp.next;
        }
        if(flag){
            System.out.println(temp.next);
        }else {
            System.out.printf("您要找的不存在，查询失败！\n");
        }
    }

    /**
     * 返回链表的结点个数
     * @return
     */
    public static int size(MyNode headNode){
        int length = 0;
        MyNode temp = (MyNode) headNode.next;
        while(temp!=null){
            length++;
            temp= (MyNode) temp.next;
        }
        return length;
    }
    /**
     * 打印链表
     */
    public void print(){
        if(headNode.next==null){
            System.out.println("链表为空！");
            return;
        }
        MyNode temp = (MyNode) headNode.next;
        while (true){
            if(temp==null)break;
            System.out.println(temp);
            temp = (MyNode) temp.next;
        }


    }
}
