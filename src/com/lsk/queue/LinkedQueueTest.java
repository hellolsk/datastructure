package com.lsk.queue;

/**
 * @Author:${六月的雨}
 * @Date:2020/6/29 22:40
 * @Description:20data_structure com.lsk.queue
 */
public class LinkedQueueTest {
    public static void main(String[] args) {
        LinkedQueue linkedQueue = new LinkedQueue();
        LinkedNode linkedNode1 = new LinkedNode(1);
        LinkedNode linkedNode2 = new LinkedNode(2);
        LinkedNode linkedNode3 = new LinkedNode(3);
        linkedQueue.inQueue(linkedNode1.getObject());
        linkedQueue.inQueue(linkedNode2.getObject());
        linkedQueue.inQueue(linkedNode3.getObject());
        int size = linkedQueue.getSize();
        System.out.println("队列大小："+size);
        System.out.println("队首元素为："+linkedQueue.getHead());
        System.out.println("队尾元素为："+linkedQueue.getTail());
        Object o = linkedQueue.outQueue();
        System.out.println("出队数据："+o);
        linkedQueue.print(linkedQueue.getFront());

    }
}
