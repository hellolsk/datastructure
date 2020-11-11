package com.lsk.recursion;

/**
 * 利用递归思想实现迷宫算法
 *
 * @Author:${六月的雨}
 * @Date:2020/7/3 09:25
 * @Description:20data_structure com.lsk.recursion
 */
public class MiGong {
    static final int X = 10;
    static final int Y = 10;

    public static void main(String[] args) {
        //初始化迷宫
        int[][] map = new int[X][Y];
        for (int i = 0; i < X; i++) {
            map[i][0] = 1;
            map[i][Y - 1] = 1;
            map[0][i] = 1;
            map[Y - 1][i] = 1;
        }
        //地图设置障碍
        map[3][1] = map[3][2] = map[3][3] = map[3][4] = 1;
        map[1][6] = map[2][6] = map[3][6] = map[4][6] = map[5][6] = map[6][6] = map[7][6]  = 1;
        System.out.println("初试地图数据：");
        print(map);

        boolean flag = forWay(map, 1, 1);
        if (flag) {
            System.out.println("走迷宫地图数据：");
            System.out.println();
            print(map);
        } else {
            System.out.println("迷宫地图无法走通!");
            print(map);
        }


    }

    /**
     * 打印地图
     *
     * @param map
     */
    public static void print(int[][] map) {
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    /**
     * 建模：map[i][j]，(1,1)和(8,8)假设分别为入口和出口
     * 以二维数组描述迷宫地图:分别用：0，表示没走过；
     *                           1，表示墙，走不通；
     *                           2，表示可以走；
     *                           3，表示走过，但不通；
     */
    /**
     * 传入地图及坐标递归需找迷宫出口
     * 制定行走路线策略为下右上左。注意根据地图规则，不同策略的效果会有不同
     *
     * @param map
     * @param x
     * @param y
     * @return
     */
    public static boolean forWay(int[][] map, int x, int y) {
        if (map[8][8] == 2) {
            return true;
        } else {
            if (map[x][y] == 0) {
                map[x][y] = 2; //假设可以走通，并标记为2
                if (forWay(map, x + 1, y)) { //向下走
                    return true;
                } else if (forWay(map, x, y + 1)) { //向右走
                    return true;
                } else if (forWay(map, x - 1, y)) { //向上走
                    return true;
                } else if (forWay(map, x, y - 1)) { //向左走
                    return true;
                } else {
                    //四个方向都不行，即为死路
                    map[x][y] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
