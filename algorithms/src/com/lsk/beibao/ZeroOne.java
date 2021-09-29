package com.lsk.beibao;

/**
 * @Author:林立可
 * @Date:2021/9/22 22:04
 * @PackageName:20data_structure com.lsk.beibao
 * @Description: 在背包的最大容量为4的时候选出价值最大的物品集合。
 */

/**
 * dp[i][j]:表示物品个数为0-i时背容量为j时的最大价值；
 */
public class ZeroOne {
    static int[] values = {15, 20, 30}; //对应物品数量
    static int[] weight = {1, 3, 4}; //对应背包数量
    static int bagWeight = 4;

    public static void main(String[] args) {
        beiBao(weight,values,bagWeight);

    }

    public static void beiBao(int[] weight,int[] values,int bagWeight) {
        //dp数组声明及初始化
        int[][] dp = new int[values.length+1][bagWeight+1];
//        for (int j = weight[0]; j <= weight.length; j++) {
//            dp[0][j] = values[0]; //一个物品时只要背包容量够，就直接放
//        }

        //先放物品再处理背包
        for (int i = 1; i <= values.length; i++) {
            for (int j = 1; j <= bagWeight; j++) {
                //当背包容量小于物品重量时,不装入背包
                if (j < weight[i-1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i-1][j-weight[i-1]]+values[i-1]);
                }
            }
        }
        //打印dp数组
        for (int i = 0; i <= values.length; i++){
            for (int j = 0; j <= bagWeight; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
