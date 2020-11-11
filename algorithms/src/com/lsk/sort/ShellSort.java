package com.lsk.sort;

import java.util.Arrays;

/**
 * @Author:${六月的雨}
 * @Date:2020/7/4 10:22
 * @Description:20data_structure com.lsk.sort
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {1, 9, 8, 0, 3, 4, 2, 5, 6, 7};
        System.out.println("最终结果：" + Arrays.toString(shellSort(arr)));
    }

    /**
     * 希尔排序
     *
     * @param arr
     * @return
     */
    public static int[] shellSort(int[] arr) {
        //控制每次的步长
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //按照步长分组
            for (int i = gap; i < arr.length; i++) {
                //对每次分组的元素进行比较
                int preIndex = i - gap; //组内的前一个元素位置
                int current = arr[i]; //当前值
                while (preIndex >= 0 && arr[preIndex] > current) { //比较组内的所以元素，并移动位置
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                //退出循环后，位置找到插入
                arr[preIndex + gap] = current;
                
                /*for (int j = i - gap; j >= 0; j -= gap) {
                    //比较一次就交换，性能影响是非常大的，没有用到插入排序的精髓，即比较后移位，最后再插入
                    if(arr[j]>arr[i]){
                        int current = arr[j];
                        arr[j] = arr[i];
                        arr[i] = current;
                    }
                }*/
            }
//            System.out.println(Arrays.toString((arr)));
        }
        return arr;
    }
}
