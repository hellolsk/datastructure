package com.lsk.recursion;

/**
 * 递归解决八皇后问题
 *
 * @Author:${六月的雨}
 * @Date:2020/7/3 15:31
 * @Description:20data_structure com.lsk.recursion
 */
public class EightQueen {
    static int N = 8;
    static int[] arr = new int[N];
    static int count = 0;

    public static void main(String[] args) {
        //从0，即第一个皇后开始
        check(0);
    }

    /*
     * ATTENTION:
     * 为了便于所有解决方案的打印，二维数组其实可以优化为一维数组。
     * 这里我们使用数组的索引+1表示行数，数组存放的值+1表示列数
     */

    /**
     * 判断当前皇后的摆放位置是否和之前冲突
     *
     * @param n 传入一个整数，表示第n+1个皇后，也表示当前行
     * @return
     */
    public static boolean isOk(int n) {
        for (int i = 0; i < n; i++){
            //列数相等或斜对角相等即不可行
            if(arr[n]==arr[i] || Math.abs(n-i)==Math.abs(arr[n]-arr[i])){
                return false;
            }
        }
        return true;
    }

    /**
     * 打印每种可能的方案
     */
    public static void print(){
        count++;
        System.out.printf("第%d种摆法:",count);
        for(int i = 0;i<N;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    /**
     * 递归判断每一种方案是否可行
     * @param n n表示当前皇后
     */
    public static void check(int n){
        //递归跳出的条件：当检查到n=N时，说明8个皇后已经放好,打印该方案
        if(n==N){
            print();
            return;
        }
        //对每一个位置进行可行性判断
        for(int i=0;i<N;i++){
            //先将第n+1个皇后放在i+1列
            arr[n] = i;
            if(isOk(n)){
                //当前位置可以，则继续下一个皇后
                check(n+1);
            }
        }

    }
}
