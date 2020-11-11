package com.lsk.sort;

/**
 * 给定数据集，测试各排序算法的性能
 *
 * @Author:${六月的雨}
 * @Date:2020/7/5 13:50
 * @Description:20data_structure com.lsk.sort
 */
public class PerformanceTest {
    static int NUM = 10000000;

    public static void main(String[] args) {
        System.out.printf("测试各排序算法的性能，数据量为%d", NUM);
        System.out.println();
       /* long start1 = getCurrentMills();
        BubbleSort.bubbleSort(creatTestArray(NUM));
        long end1 = getCurrentMills();
        System.out.println("冒泡排序时间(s)：" + (end1 - start1) / 1000L);
        long start2 = getCurrentMills();
        SelectSort.selectSort(creatTestArray(NUM));
        long end2 = getCurrentMills();
        System.out.println("选择排序时间(s)：" + (end2 - start2) / 1000L);
        long start5 = getCurrentMills();
        InsertSort.insertSort(creatTestArray(NUM));
        long end5 = getCurrentMills();
        System.out.println("插入排序时间(s)：" + (end5 - start5) / 1000L);*/
        long start3 = getCurrentMills();
        MergeSort.mergeSort(creatTestArray(NUM));
        long end3 = getCurrentMills();
        System.out.println("归并排序时间(s)：" + (end3 - start3) / 1000L);
        long start4 = getCurrentMills();
        ShellSort.shellSort(creatTestArray(NUM));
        long end4 = getCurrentMills();
        System.out.println("希尔排序时间(s)：" + (end4 - start4) / 1000L);

        long start6 = getCurrentMills();
        QuickSort.quickSort(creatTestArray(NUM),0,NUM-1);
        long end6 = getCurrentMills();
        System.out.println("快速排序时间(s)：" + (end6 - start6) / 1000L);
    }

    /**
     * 创建一个随机数组
     *
     * @param NUM 数组容量
     * @return
     */
    public static int[] creatTestArray(int NUM) {
        int[] arr = new int[NUM];
        for (int i = 0; i < NUM; i++) {
            arr[i] = (int) (Math.random() * NUM);
        }
        return arr;
    }

    public static long getCurrentMills() {
        return System.currentTimeMillis();
    }
}
