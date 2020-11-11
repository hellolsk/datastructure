package com.lsk.basic;

/**
 * 利用牛顿迭代法求平方根
 * @Author:${六月的雨}
 * @Date:2020/6/29 17:42
 * @Description:20data_structure com.lsk.basic
 */
public class SQRT {
    public static void main(String[] args) {

    }
    public static void sqrt(double m){
        if(m<0){
            System.out.println("error!");
            return;
        }
        //允许的误差范围
        double err = 1e-15;
        double t = m;
        while(Math.abs(t-t/m)>err){

        }

    }
}
