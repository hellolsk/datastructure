package com.lsk.stack;


/**
 * @Author:${六月的雨}
 * @Date:2020/6/30 09:00
 * @Description:20data_structure com.lsk.stack
 */
public class LinkedStack {
    public LinkedNode top;

    /**
     * 初始化栈
     */
    public LinkedStack() {
        top = new LinkedNode(null);
    }

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty(){
        return top==null;
    }

    /**
     * 入栈
     * @param object
     */
    public void push(Object object){
        LinkedNode node = new LinkedNode(object);
        if(top.getObject()==null){
            top.setObject(object);
        }else if(top==null){
            top = node;
        }else{
            node.setNext(top);
            top = node;
        }
    }

    /**
     * 出栈
     * @return
     */
    public Object pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空，出栈失败！");
        }
        Object object = top.getObject();
        top = top.getNext();
        return object;
    }

    /**
     * 遍历栈
     * @param top
     */
    public void print(LinkedNode top){
        if(isEmpty()){
            System.out.println("链表为空！");
            return;
        }
        while (top!=null){
            System.out.println(top.getObject());
            top = top.getNext();
        }
    }
}

class LinkedNode{
    private LinkedNode next;
    private Object object;

    public LinkedNode(Object object) {
        this.object = object;
    }

    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "LinkedNode{" +
                "object=" + object +
                '}';
    }
}
