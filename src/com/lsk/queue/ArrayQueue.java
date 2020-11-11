package com.lsk.queue;

/**
 * @Author:${六月的雨}
 * @Date:2020/6/14 20:50
 * @Description:20data_structure com.lsk.queue
 */

/**
 * 定义队列,用数组实现
 */
public class ArrayQueue {
    private int front; //队头
    private int rear; //队尾
    private int[] arr; //存放数据的数组
    private int capacity; //定义数组容量
    private int DEFAULT_SIZE = 10; //定义默认数组容量

    /**
     * 无参构造器，默认初始化
     */
    public ArrayQueue() {
        capacity = DEFAULT_SIZE;
        arr = new int[capacity];
        front = -1;
        rear = -1;
    }

    /**
     * 有参构造器初始化一个队列，长度为arrMaxSize
     * 注意：队头队尾，外加一个长度唯一确定一个队列
     *
     * @param size
     */
    public ArrayQueue(int size) {
        capacity = size;
        arr = new int[capacity];
        front = -1;
        rear = -1;
    }

    /**
     * 判断队列是否满
     *
     * @return
     */
    public boolean isFull() {
        return rear == capacity - 1;
    }

    /**
     * 判断队列是否空
     *
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 入队操作
     *
     * @param n
     */
    public void inQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满！入队失败！");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    /**
     * 出队
     *
     * @return
     */
    public void outQueue() {
        if (isEmpty()) {
            System.out.println("队列为空！出队失败！");
        }
        front++;
        arr[front] = 0;
    }

    /**
     * 获得队首元素
     *
     * @return
     */
    public int getHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，取出失败！");
        }
        return arr[front + 1];

    }

    /**
     * 获得队尾元素,注意这里不需要移动尾指针，当前尾指针即为要获得元素
     *
     * @return
     */
    public int getTail() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，取出失败！");
        }
        return arr[rear];
    }

    /**
     * 获得队列的实际大小
     *
     * @return
     */
    public int getSize() {
        int size = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                size++;
            }
        }
        return size;
    }

    /**
     * 打印队列中的数据
     */
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("队列为空！");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }
}


