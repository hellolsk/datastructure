package com.lsk.stack;

/**
 * @Author:${六月的雨}
 * @Date:2020/6/30 21:48
 * @Description:20data_structure com.lsk.stack
 */
public class LinkedStackTest {
    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push(1);
        linkedStack.push(2);
        linkedStack.push(3);
        linkedStack.pop();
        linkedStack.print(linkedStack.top);
    }
}
