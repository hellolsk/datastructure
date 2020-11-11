package com.lsk.find;

/**
 * @Author:${六月的雨}
 * @Date:2020/7/16 20:16
 * @Description:20data_structure com.lsk.find
 */
public class SequenceSearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,6,9,4,8,5};
        int result = sequenceSearch(arr, 5);
        System.out.println(result);
    }

    /**
     * 线性查找，即遍历集合
     * @param arr
     * @param key
     * @return
     */
    public static int sequenceSearch(int[] arr,int key){
        for(int i =0;i<arr.length;i++){
            if(arr[i]==key){
                return i;
            }
        }
        return -1;
    }
}
