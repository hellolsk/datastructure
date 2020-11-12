package com.lsk.graph;

import java.util.Arrays;

/**
 * @Author:${六月的雨}
 * @Date:2020/11/12 10:50
 * @Description:20data_structure com.lsk.graph
 */
public class Kruskal {
    public static void main(String[] args) {
        int INF = KGraph.getINF();
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int martix[][] = {
                //A,B,C,D,E,F,G
                {0, 12, INF, INF, INF, 16, 14},
                {12, 0, 10, INF, INF, 7, INF},
                {INF, 10, 0, 3, 5, 6, INF},
                {INF, INF, 3, 0, 4, INF, INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0},
        };
        KGraph graph = new KGraph(vertex, martix);
        //graph.print();
        KEdges[] edges = graph.getEdges();
        //存放边数
        int edgeNum = graph.getEdgeNum();
        //存放终点下标
        int ends[] = new int[edgeNum];
        //存放结果
        KEdges results[] = new KEdges[edgeNum];
        int index = 0;
        System.out.println("排序前：" + Arrays.toString(edges));
        graph.sortEdges(edges);
        System.out.println("排序后：" + Arrays.toString(edges));
        for(int i =0;i<edgeNum;i++){
            //分别获取第一条边的起点和终点下标
            int p1 = graph.getPosition(edges[i].start);
            int p2 = graph.getPosition(edges[i].end);

            //分别对起点和终点下标检查他们的终点
            int m = graph.getEnd(ends,p1);
            int n = graph.getEnd(ends,p2);
            if(m!=n){
                //如果不相等，可以加入；并将当前结点标记为终点
                ends[m] = n;
                results[index++] = edges[i];
            }
        }
        System.out.println("最小生成树:");
        for(int i =0;i<index;i++){
            System.out.println(results[i]);
        }
    }
}

class KGraph {
    private int edgeNum; //边数
    private char[] vertex; // 顶点集合
    private int[][] matrix; // 边集合,邻接矩阵
    //使用Integer的最大值表示结点不连通
    private static final int INF = Integer.MAX_VALUE;

    public int getEdgeNum() {
        return edgeNum;
    }

    public void setEdgeNum(int edgeNum) {
        this.edgeNum = edgeNum;
    }

    public char[] getVertex() {
        return vertex;
    }

    public void setVertex(char[] vertex) {
        this.vertex = vertex;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public static int getINF() {
        return INF;
    }

    //初试化构造器
    public KGraph(char[] vertex, int[][] matrix) {
        //1,拷贝的方式实现初始化
        int length = vertex.length;
        this.vertex = new char[vertex.length];
        for (int i = 0; i < vertex.length; i++) {
            this.vertex[i] = vertex[i];
        }
        this.matrix = new int[length][length];
        for (int i = 0; i < length; i++) {
            this.matrix[i] = matrix[i];
        }
        //2,统计边的条数
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }

    }

    /**
     * 打印矩阵
     */
    public void print() {
        System.out.println("邻接矩阵为：");
        for (int i = 0; i < vertex.length; i++) {
            for (int j = 0; j < vertex.length; j++) {
                System.out.printf("%12d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 对边进行按权值排序，冒泡
     *
     * @param edges
     */
    public void sortEdges(KEdges[] edges) {
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - i - 1; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    KEdges temp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 获得"边数组"
     *
     * @return
     */
    public KEdges[] getEdges() {
        int index = 0;
        KEdges[] edges = new KEdges[edgeNum];
        for (int i = 0; i < vertex.length; i++) {
            for (int j = i+1; j < vertex.length; j++) {
                if (matrix[i][j] != INF) {
                    edges[index++] = new KEdges(vertex[i], vertex[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }

    /**
     * 获取顶点下标
     * @param ch
     * @return
     */
    public int getPosition(char ch){
        for(int i =0;i<vertex.length;i++){
            if(vertex[i]==ch){
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取下标为i顶点的终点下标
     * @param end 记录对应顶点的终点，该数组在遍历过程中逐步生成
     * @param i 传入的顶点下标
     * @return 返回当前顶点的终点下标
     */
    public int getEnd(int[] end,int i){
        //循环：会更新连通的顶点到最远终点；
        //比如这里的CDE结点，<C,E>,<D,E>,<C,E>;那么C和E的终点都是E
        while (end[i] !=0){
            i = end[i];
        }
        return i;
    }
}

/**
 * 表示边的构造
 */
class KEdges {
    char start;
    char end;
    int weight;

    public KEdges(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "KEdges{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}

