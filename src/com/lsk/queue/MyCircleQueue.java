package com.lsk.queue;

import java.util.Scanner;

/**
 * @Author:${六月的雨}
 * @Date:2020/6/15 19:41
 * @Description:20data_structure com.lsk.queue
 */
public class MyCircleQueue {
    public static void main(String[] args) {
        ArrayCircleQueue circleQueue = new ArrayCircleQueue(3);
        System.out.println("测试环形队列，请选择：");
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
                    circleQueue.printQueue();
                    break;
                case 'i':
                    System.out.println("输入入队元素:");
                    int in = scanner.nextInt();
                    circleQueue.inQueue(in);
                    break;
                case 'o':
                    circleQueue.outQueue();
                    System.out.println("出队成功");
                    break;
                case 'h':
                    int head = circleQueue.getHead();
                    System.out.println("队首元素为:"+head);
                    break;
                case 't':
                    int tail = circleQueue.getTail();
                    System.out.println("队尾元素为:"+tail);
                    break;
                case 's':
                    int size = circleQueue.getSize();
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
