package com.lsk.find;

/**
 * @Author:${六月的雨}
 * @Date:2020/7/16 22:24
 * @Description:20data_structure com.lsk.find
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,6,9,12,55,16};
        System.out.println(insertValueSearch(arr,0,arr.length-1,10));
    }

    /**
     * 插值查找
     * @param arr
     * @param left
     * @param right
     * @param key
     * @return
     */
    public static int insertValueSearch(int[] arr, int left, int right, int key) {
        int mid = left + ((key - arr[left]) / (arr[right] - arr[left])) * (right - left);
        //递归边界
        if(left>right){
            return -1;
        }
        if(key>arr[mid]){
            return insertValueSearch(arr,mid+1,right,key);
        }
        else if(key<arr[mid]){
            return insertValueSearch(arr,left,mid-1,key);
        }
        else {
            return mid;
        }
    }
}
