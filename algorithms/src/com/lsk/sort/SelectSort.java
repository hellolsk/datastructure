package com.lsk.sort;

import java.util.Arrays;

/**
 * @Author:${六月的雨}
 * @Date:2020/7/3 18:39
 * @Description:20data_structure com.lsk.sort
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {1, 9, 8, 0, 3, 4, 2, 5, 6, 7};
        System.out.println(Arrays.toString(selectSort(arr)));

    }

    /**
     * 选择排序
     * @param arr
     * @return
     */
    public static int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i]; //选择一个作为最小值
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    int temp = arr[j];
                    arr[j] = min;
                    min = temp;
                }
            }
        }
        return arr;
    }
}
