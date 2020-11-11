package com.lsk.sort;

import java.util.Arrays;

/**
 * @Author:${六月的雨}
 * @Date:2020/7/3 19:49
 * @Description:20data_structure com.lsk.sort
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {1, 9, 8, 0, 3, 4, 2, 5, 6, 7};
        System.out.println(Arrays.toString(insertSort(arr)));
    }

    /**
     * 插入排序
     * @param arr
     * @return
     */
    public static int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //当前需要插入的元素
            int current = arr[i];
            //被插入的位置,即当前数的前一个
            int preIndex = i - 1;
            while (preIndex >= 0 && current < arr[preIndex]) {
                //被插入位置的元素后移
                arr[preIndex + 1] = arr[preIndex];
                //索引向前移动
                preIndex--;
            }
            //当前值插入的位置
            arr[preIndex + 1] = current;
        }
        return arr;
    }
}
