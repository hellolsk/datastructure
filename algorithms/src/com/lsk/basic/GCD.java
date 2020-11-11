package com.lsk.basic;

/**
 * 求两个数的最大公约数
 *
 * @Author:${六月的雨}
 * @Date:2020/6/29 17:01
 * @Description:20data_structure com.lsk.basic
 */
public class GCD {
    public static void main(String[] args) {
        int gcd = gcd(6, 8);
        System.out.println("gcd is :" + gcd);
    }

    /**
     * 利用递归实现最大公约数
     *
     * @param m
     * @param n
     * @return
     */
    public static int gcd(int m, int n) {
        if (n == 0) {
            return m;
        }
        int r = m % n;
        return gcd(n, r);
    }
}
