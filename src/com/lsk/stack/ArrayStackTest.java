package com.lsk.stack;

/**
 * @Author:${六月的雨}
 * @Date:2020/6/29 21:13
 * @Description:20data_structure com.lsk.stack
 */
public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(3);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.print();
        int head = arrayStack.getHead();
        System.out.println(head);
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.print();
    }
}
