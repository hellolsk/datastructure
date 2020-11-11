package com.lsk.sort;

import java.util.Arrays;

/**
 * @Author:${六月的雨}
 * @Date:2020/7/5 10:13
 * @Description:20data_structure com.lsk.sort
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr={8,4,5,7,1,3,6,2,9};
        System.out.println(Arrays.toString(mergeSort(arr)));
    }

    /**
     * 归并排序：分治思想，先分再治
     *
     * @param arr
     * @return
     */
    public static int[] mergeSort(int[] arr) {
        //“分”结束的条件
        if (arr.length < 2) {
//            System.out.println("分："+Arrays.toString(arr));
            return arr;
        }
        int mid = arr.length / 2;
        //均分成两个数组序列
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    /**
     * “治”:将"分"好的数组序列组合起来
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right) {
        //返回拼装好的结果数组
        int[] result = new int[left.length + right.length];
        //i,j,分别为左右序列的索引,index为结果集的索引
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length) //当序列的索引超过其长度时，说明序列已经排完，只需将另一个序列依次加入结果集中即可
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j]) //左右序列的数据依次进行比较，小的加入到结果集中
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
//        System.out.println(Arrays.toString(result));
        return result;
    }
}
