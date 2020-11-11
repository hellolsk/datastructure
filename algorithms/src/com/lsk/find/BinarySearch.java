package com.lsk.find;

/**
 * @Author:${六月的雨}
 * @Date:2020/7/16 20:28
 * @Description:20data_structure com.lsk.find
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,6,9,22,55,100};
        System.out.println(recursionbBinarySearch(arr,0,arr.length-1,10));
    }

    /**
     * 二分查找的前提是数组有序
     * @param arr
     * @param key
     * @return
     */
    public static int binarySearch(int[] arr,int key){
        int left = 0;
        int right = arr.length-1;
        int mid = (left+right)/2;
        while(left<=right){
            if(arr[mid]<key){
                left=mid+1;
            }else if(arr[mid]>key){
                right = mid-1;
            }
            else{
                return mid;
            }
            mid=(left+right)/2;
        }
        return -1;
    }

    /**
     * 递归二分查找
     * @param arr
     * @param left
     * @param right
     * @param key
     * @return
     */
    public static int recursionbBinarySearch(int[] arr,int left,int right,int key){
        int mid = (left+right)/2;
        //递归边界
        if(left>right){
            return -1;
        }
        if(key>arr[mid]){
            return recursionbBinarySearch(arr,mid+1,right,key);
        }
        else if(key<arr[mid]){
            return recursionbBinarySearch(arr,left,mid-1,key);
        }
        else {
            return mid;
        }
    }
}
