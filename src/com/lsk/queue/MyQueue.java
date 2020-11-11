package com.lsk.queue;

import java.util.Scanner;

/**
 * @Author:${六月的雨}
 * @Date:2020/6/15 14:44
 * @Description:20data_structure com.lsk.queue
 */
public class MyQueue {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(2);
        System.out.println("请选择：");
        System.out.println("p(打印队列)");
        System.out.println("i(入队)");
        System.out.println("o(出队");
        System.out.println("s(队列大小)");
        System.out.println("h(队头元素)");
        System.out.println("t(队尾元素)");
        System.out.println("e(结束演示)");
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while(flag){
            char key = scanner.next().charAt(0);
            switch (key){
                case 'p':
                    arrayQueue.printQueue();
                    break;
                case 'i':
                    System.out.println("输入入队元素:");
                    int in = scanner.nextInt();
                    arrayQueue.inQueue(in);
                    break;
                case 'o':
                    arrayQueue.outQueue();
                    System.out.println("出队成功");
                    break;
                case 'h':
                    int head = arrayQueue.getHead();
                    System.out.println("队首元素为:"+head);
                    break;
                case 't':
                    int tail = arrayQueue.getTail();
                    System.out.println("队尾元素为:"+tail);
                    break;
                case 's':
                    int size = arrayQueue.getSize();
                    System.out.println("队列实际大小为:"+size);
                    break;
                case 'e':
                    flag = false;
                    System.out.println("谢谢访问！");
                    break;
            }
        }


    }
}
