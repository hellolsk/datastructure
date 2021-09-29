package com.lsk.set;

/**
 * @Author:林立可
 * @Date:2021/8/21 16:19
 * @PackageName:20data_structure com.lsk.set
 * @Description:
 */
public class Test02 {
    public static void main(String[] args) {
        int count = 0;
//        二维数组n*2
        int[][] a = {{3,4},{4,5},{5,6},{4,7},{3,8}};
        for(int i=0 ; i <a.length ; i++) {
            for(int j=0 ; j<a[i].length ; j++) {
                System.out.println("a[" + i + "][" + j + "]=" + a[i][j]) ;
            }
        }
        for(int i =0;i<5-1;i++){//列
            for(int j=i+1;j<5;j++){ //行
                if( Math.abs(a[i][0]-a[j][0]) == Math.abs(a[i][1]-a[j][1]))
                {count++;}
            }
        }
        System.out.println(count);
    }
}
