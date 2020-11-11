package com.lsk.stack;

import java.util.Scanner;

/**
 * @Author:${六月的雨}
 * @Date:2020/7/1 16:22
 * @Description:20data_structure com.lsk.stack
 */
public class Calculator {
    public static void main(String[] args) {

        String expression = getInput();
        CalculatorStack numStack = new CalculatorStack(10);
        CalculatorStack optionStack = new CalculatorStack(10);
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int option = 0;
        int result = 0;
        char ch = ' '; //用于保存每次截取的字符
        String temp = ""; //使用字符串存储数字是否是可能的多位数

        //遍历表达式,直到索引遍历完毕跳出该循环
        while (true) {
            //截取每次取得的字符
            ch = expression.substring(index, index+1).charAt(0);
            //判断，操作符入字符栈
            if (optionStack.isOper(ch)) {
                if (!optionStack.isEmpty()) {
                    //不为空，则比较优先级
                    if (optionStack.priority(ch) <= optionStack.priority(optionStack.getHead())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        option = optionStack.pop();
                        result = optionStack.execute(num1, num2, option);
                        numStack.push(result);
                        optionStack.push(ch);
                    }else {
                        //栈优先级大于当前优先级，入栈
                        optionStack.push(ch);
                    }
                }else {
                    //为空直接入栈
                    optionStack.push(ch);
                }
            } else {
                //不是操作符，入数字栈

                /**
                 * 处理可能是多位数的问题：首先使用字符串存储这个可能的多位数
                 */

                temp += ch;
                //如果遍历到末尾直接入栈
                if(index == expression.length()-1){
                    numStack.push(Integer.parseInt(temp));
                }else {
                    //下一位如果是操作符,同样直接入栈
                    if(optionStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                        numStack.push(Integer.parseInt(temp));
                        temp="";//每次使用完后要置空
                    }
                }
            }
            //指针后移，继续遍历
            index++;
            if(index > expression.length()-1){
                break;
            }
        }

        //取出数据
        while(true){
            if(optionStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            option = optionStack.pop();
            result = optionStack.execute(num1, num2, option);
            numStack.push(result);
        }
        //最后数字栈的结果就是最终结果
        System.out.printf("表达式%s=%d",expression,numStack.pop());
    }

    /**
     * 从用户界面录入表达式
     * @return
     */
    public static String getInput(){
        System.out.println("输入表达式:");
        Scanner scanner = new Scanner(System.in);
        return  scanner.next();
    }

}

//使用数组模拟栈，同时基于业务进行方法增强
class CalculatorStack {
    private int[] stack;
    private int size;
    private int top = -1;

    //构造器，初始化
    public CalculatorStack(int size) {
        this.size = size;
        stack = new int[this.size];
    }

    /**
     * 栈满
     *
     * @return
     */
    public boolean isFull() {
        return top == size - 1;
    }

    /**
     * 判断栈空
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈
     *
     * @param value
     */
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满！");
            return;
        }
        top++;
        stack[top] = value;
    }

    /**
     * 出栈
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，出栈失败！");
        }
        int value = stack[top];
        top--;
        return value;
    }

    /**
     * 获得栈顶元素
     *
     * @return
     */
    public int getHead() {
        return stack[top];
    }

    /**
     * 根据操作符返回优先级,注意这里char和int可以直接操作
     *
     * @param option
     * @return
     */
    public int priority(int option) {
        if (option == '*' || option == '/') {
            return 1;
        } else if (option == '+' || option == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 区分是否是操作符
     *
     * @param option
     * @return
     */
    public boolean isOper(char option) {
        return option == '*' || option == '/' || option == '+' || option == '-';
    }

    /**
     * 弹栈后执行表达式
     *
     * @param num1
     * @param num2
     * @param option
     * @return
     */
    public int execute(int num1, int num2, int option) {
        int result = 0;
        switch (option) {
            case '*':
                result = num2 * num1;
                break;
            case '/':
                result = num2 / num1;
                break;
            case '+':
                result = num2 + num1;
                break;
            case '-':
                result = num2 - num1; //注意使用弹栈顺序
                break;
            default:
                break;
        }
        return result;
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
}

