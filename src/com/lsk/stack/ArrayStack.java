package com.lsk.stack;

/**
 * @Author:${六月的雨}
 * @Date:2020/6/29 18:10
 * @Description:20data_structure com.lsk.stack
 */
public class ArrayStack {
    private int[] stack;
    private int size;
    private int top = -1;

    //构造器，初始化
    public ArrayStack(int size) {
        this.size = size;
        stack = new int[this.size];
    }

    /**
     * 栈满
     * @return
     */
    public boolean isFull(){
        return top == size-1;
    }

    /**
     * 判断栈空
     * @return
     */
    public boolean isEmpty(){
        return top==-1;
    }

    /**
     * 入栈
     * @param value
     */
    public void push(int value){
        if(isFull()){
            System.out.println("栈满！");
            return;
        }
        top++;
        stack[top] = value;
    }

    /**
     * 出栈
     */
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空，出栈失败！");
        }
        int value = stack[top];
        top--;
        return value;
    }

    /**
     * 打印栈
     */
    public void print(){
        if(isEmpty()){
            System.out.println("栈空！");
            return;
        }
        for(int i=top;i>=0;i--){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
    /**
     * 获得栈顶元素
     *
     * @return
     */
    public int getHead() {
        return stack[top];
    }

}
