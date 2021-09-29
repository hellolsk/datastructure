package com.lsk.sort;

import java.util.Arrays;

/**
 * @Author:${六月的雨}
 * @Date:2020/7/3 17:46
 * @Description:20data_structure com.lsk.sort
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 9, 8, 0, 3, 4, 2, 5, 6, 7};
        System.out.println(Arrays.toString(bubbleSort(arr)));

    }

    /**
     * 冒泡排序:优化：如果一趟排序中没有发生冒泡，说明数组已经有序即可退出循环
     * 从小到大排序
     * @param arr
     */
    public static int[] bubbleSort(int[] arr) {
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            //每冒泡一次，最大的都会冒泡到最顶端
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                System.out.println("第" + (i + 1) + "次冒泡" + Arrays.toString(arr));
                flag = false;
            }
        }
        return arr;
    }
}
