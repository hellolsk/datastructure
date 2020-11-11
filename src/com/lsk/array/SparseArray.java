package com.lsk.array;

import java.io.*;

/**
 * @Author:${六月的雨}
 * @Date:2020/6/14 15:13
 * @Description:20data_structure com.lsk.array
 */
public class SparseArray {
    public static void main(String[] args) throws IOException {
        int[][] arr = new int[3][3];
        arr[0][0] = 1;
        arr[1][1] = 2;
        arr[1][2] = 3;
        arr[2][1] = 5;
        System.out.println("原始数组为：");
        printArr(arr);
        int[][] spareArray = spareArray(arr);
        System.out.println("压缩的稀疏数组为：");
        printArr(spareArray);
        saveToDisk(spareArray);
        int[][] orignArr = unSparseArr(spareArray);
        System.out.println("稀疏数组还原为原始数组：");
        printArr(orignArr);

    }

    /**
     * 压缩稀疏数组实现方法
     *
     * @param arr 原始数组
     * @return 稀疏数组
     */
    public static int[][] spareArray(int arr[][]) {
        //计算原始数组非0元素个数
        int sum = 0;
        int row = arr.length;
        int column = arr[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (arr[i][j] != 0) {
                    sum++;
                }
            }
        }
        int sparseArr[][] = new int[sum + 1][3];
        sparseArr[0][0] = row;
        sparseArr[0][1] = column;
        sparseArr[0][2] = sum;

        int count = 0;//记录不同值得序号
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (arr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = arr[i][j];
                }
            }
        }
        return sparseArr;
    }

    /**
     * 根据稀疏数组还原为原始数组
     *
     * @param arr
     * @return
     */
    public static int[][] unSparseArr(int arr[][]) {
        int row = arr[0][0];
        int column = arr[0][1];
        int sum = arr[0][2];
        int orignArr[][] = new int[row][column];
        for (int i = 1; i < sum + 1; i++) {
                orignArr[arr[i][0]][arr[i][1]] = arr[i][2];
        }
        return orignArr;
    }

    /**
     * 将数组写入到磁盘中
     * @param arr
     * @throws IOException
     */
    public static void saveToDisk(int arr[][]) throws IOException {
        File file = new File("d:/temp/arr.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        //创建字符写入流对象
        FileOutputStream fo = new FileOutputStream(file);
        OutputStreamWriter writer = new OutputStreamWriter(fo, "utf8");
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                bufferedWriter.write(arr[i][j]+"\t");//注意这里需用字符的形式写入，不然会乱码
            }
            bufferedWriter.write("\r\n");
        }
        bufferedWriter.close();
        writer.close();
        fo.close();
        System.out.println("保存成功！");
    }

    /**
     * 打印二维数组方法
     *
     * @param arrs
     */
    public static void printArr(int arrs[][]) {
        for (int[] arr : arrs) {
            for (int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}
