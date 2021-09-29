package com.lsk.sort;

import java.util.Arrays;

/**
 * @Author:${六月的雨}
 * @Date:2020/7/4 16:13
 * @Description:20data_structure com.lsk.sort
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1,6,7,8,9,5,2,4,3,0};
        quickSort(arr,0,arr.length-1);
        System.out.println("last is :"+Arrays.toString(arr));
    }

    /**
     * 交换数组内的两个元素
     * @param a
     * @param n
     * @param m
     */
    public static void swap(int[] a,int n,int m){
        int temp = a[n];
        a[n] = a[m];
        a[m] = temp;
    }

    /**
     * 快速排序
     * @param arr
     * @param start 起始位置
     * @param end 终点位置
     * @return
     */
    public static void quickSort(int[] arr,int start,int end){
        //标记索引，记录当前位置
        int low = start;
        int high = end;
        int key = arr[low]; //基准值一般选择序列第一个元素
        while(start<end){
            //从后往前遍历，直到找到较小值
            while(start<end && arr[end]>=key){
                end--;
            }
            //退出时如果找到，即交换位置
            if(arr[end]<=key){
                swap(arr,start,end);
            }
            //从前往后遍历，直到找到较大值
            while(start<end && arr[start]<=key){
                start++;
            }
            if(arr[start]>=key){
                swap(arr,start,end);
            }
        }
        //一遍排序结束，基准值位置就确定了，即左边均小于它，右边均大于它
//        System.out.println("start："+start);
        System.out.println(Arrays.toString(arr));
        //如果当前起始位置大于标记,说明左边序列仍有元素，对左序列递归进行快速排序
        if(start>low){
            quickSort(arr,low,start-1);
        }
        //如果当前终点位置小于标记,说明右边序列仍有元素，对右序列递归进行快速排序
        if(end<high){
            quickSort(arr,end+1,high);
        }
    }
}
