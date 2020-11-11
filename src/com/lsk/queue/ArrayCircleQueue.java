package com.lsk.queue;

/**
 * @Author:${六月的雨}
 * @Date:2020/6/15 19:15
 * @Description:20data_structure com.lsk.queue
 */

/**
 * 环形队列能够解决普通队列不能重复使用的问题，只要队列没满的情况下，环形队列就可以反复使用
 */
public class ArrayCircleQueue {
    private int capacity;
    private int front;
    private int rear;
    private int[] arr;
    private int DEFAULT_CAPACITY;

    /**
     * 构造器初始化循环链表
     *
     * @param size
     */
    public ArrayCircleQueue(int size) {
        capacity = size;
        front = 0;
        rear = 0;
        arr = new int[capacity];
    }

    public ArrayCircleQueue() {
        capacity = DEFAULT_CAPACITY;
        front = 0;
        rear = 0;
        arr = new int[capacity];
    }

    /**
     * 会留有一个位置用于区分队满与队空的情况
     *
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void inQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满！入队失败！");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % capacity;
        System.out.println("入队成功！");
    }

    /**
     * 出队列，取出后队尾指针需要后移一个元素
     */
    public void outQueue() {
        if (isEmpty()) {
            System.out.println("队列为空！出队失败！");
        }
        arr[front] = 0;
        front = (front+1)%capacity;
    }
    /**
     * 获得队首元素
     * @return
     */
    public int getHead(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，取出失败！");
        }
        return arr[front];

    }

    /**
     * 获得队尾元素
     * @return
     */
    public int getTail(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，取出失败！");
        }
        return arr[(Math.abs(rear - 1)) % capacity];
    }


    /**
     * 获得队列的实际大小
     *
     * @return
     */
    public int getSize() {
        return (rear + capacity - front) % capacity;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("队列为空！");
            return;
        }
        //注意这里为什么需要是i%capacity:解决数组下标越界的问题
        for (int i = front; i < front + getSize(); i++) {
            System.out.printf("arr[%d]=%d\n", i%capacity, arr[i%capacity]);
        }
    }
}
