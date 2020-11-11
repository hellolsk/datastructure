package com.lsk.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 利用栈实现逆波兰表达式20+30*2-3
 *
 * @Author:${六月的雨}
 * @Date:2020/7/2 11:40
 * @Description:20data_structure com.lsk.stack
 */
public class PolandNotation {
    public static void main(String[] args) {
        System.out.println("请输入逆波兰表达式：");
        ArrayList<String> list = getList();
        int execute = execute(list);
        System.out.printf("逆波兰表达式%s的结果为%d",list,execute);
    }

    /**
     * 将输入的字符串转换为arrayList集合
     * @return
     */
    public static ArrayList<String> getList() {
        String expression = new Scanner(System.in).nextLine();
        String[] split = expression.split(" ");
        ArrayList<String> arrayList = new ArrayList<>();
        for (String s : split) {
            arrayList.add(s);
        }
        return arrayList;
    }


    /**
     * 入栈执行计算
     * @param arrayList
     * @return
     */
    public static int execute(List<String> arrayList) {
        Stack<String> stack = new Stack();
        for (String str : arrayList) {
            //使用正则表达式匹配1或多个整数，第一个\表示转义
            if (str.matches("\\d+")) {
                stack.push(str);
            } else {
                int pop1 = Integer.parseInt(stack.pop());
                int pop2 = Integer.parseInt(stack.pop());
                int result = 0;
                if (str.equals("+")) {
                    result = pop1 + pop2;
                } else if (str.equals("-")) {
                    result = pop2 - pop1;
                } else if (str.equals("*")) {
                    result = pop2 * pop1;
                } else if (str.equals("/")) {
                    result = pop2 / pop1;
                }else {
                    throw new RuntimeException("输入字符错误！");
                }
                stack.push(""+result);
            }
        }
        //返回栈中数据即为最终结果
        return Integer.parseInt(stack.pop());
    }
}
