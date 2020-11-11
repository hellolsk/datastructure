package com.lsk.test;

/**
 * @Author:${六月的雨}
 * @Date:2020/7/1 16:58
 * @Description:20data_structure com.lsk.test
 */
public class Test {
    public static void main(String[] args) {
        /*byte [] bytes = new byte[1];
        byte b = (byte) Integer.parseInt("10101000", 2);
        System.out.println(b);
        bytes[0] = b;
        System.out.println(Arrays.toString(bytes));*/
        byte b = 2;
        int temp = b;
        System.out.println(temp);
        temp |= 256;
        String string = Integer.toBinaryString(temp);
        System.out.println(string);
        System.out.println(string.substring(string.length()-8));
    }
    public static void print(int n){
        if(n>1){
            print(n-1);
        }
        System.out.println("n="+n);
    }
}
