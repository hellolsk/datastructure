package com.lsk.queue;

/**
 * @Author:${六月的雨}
 * @Date:2020/6/29 21:28
 * @Description:20data_structure com.lsk.queue
 */
public class LinkedQueue {
    private LinkedNode front;
    private LinkedNode rear;

    public LinkedNode getFront() {
        return front;
    }

    public void setFront(LinkedNode front) {
        this.front = front;
    }

    public LinkedNode getRear() {
        return rear;
    }

    public void setRear(LinkedNode rear) {
        this.rear = rear;
    }

    /**
     * 构造器初始化链队列，队首队尾默认指向空
     */
    public LinkedQueue() {
        front=rear=null;
    }

    /**
     * 判断队列是否为空,注意不需判断队列满的情况
     * @return
     */
    public boolean isEmpty(){
        return front==rear;
    }

    /**
     * 获取链队列的长度
     * @return
     */
    public int getSize(){
        int size = 0;
        LinkedNode temp = front;
        while(null!=temp){
            size++;
            temp = temp.getNext();
        }
        return size;
    }

    /**
     * 入队操作
     * @param object
     */
    public void inQueue(Object object){
        LinkedNode linkedNode = new LinkedNode(object);
        if(front==null){
            front = linkedNode;
            rear = front;
        }else{
            rear.setNext(linkedNode);
            rear = linkedNode;
        }
    }

    /**
     * 出队
     * @return
     */
    public Object outQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，出队失败！");
        }
        LinkedNode temp = front;
        front = front.getNext();
        if(temp == rear){
            rear = null;
        }
        return temp.getObject();
    }

    /**
     * 获得队首元素
     * @return
     */
    public Object getHead(){
        if(front==null) {
           throw new RuntimeException("队列为空！");
        }
        return front.getObject();
    }

    /**
     * 获得队尾元素
     * @return
     */
    public Object getTail(){
        if(isEmpty()){
            throw new RuntimeException("队列为空！");
        }
        return rear.getObject();
    }

    /**
     * 递归打印链表队列
     * @param front
     */
    public void print(LinkedNode front){
        if(isEmpty()){
            System.out.println("队列为空！");
            return;
        }
        if(front!=null){
            System.out.println(front.getObject());
            LinkedNode temp = front.getNext();
            print(temp);
        }else {
            return;
        }

    }

}

/**
 * 此处自定义一个结点类
 */
class LinkedNode {
    private LinkedNode next;    //下一结点的引用
    private Object object;  //存放的数据对象

    public LinkedNode() {
        object = null;
    }

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
                " object=" + object +
                '}';
    }
}
