package com.lsk.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author:${六月的雨}
 * @Date:2020/10/28 19:32
 * @Description:20data_structure com.lsk.graph
 */
public class Prime {
    public static void main(String[] args) {
        TGraph graph = new TGraph(7);
        String[] strings = new String[]{"A", "B", "C", "D", "E", "F", "G"};
        for (String s : strings) {
            graph.vertex.add(s);
        }
        graph.insert(0, 1, 5);
        graph.insert(0, 2, 7);
        graph.insert(0, 6, 2);
        graph.insert(1, 3, 9);
        graph.insert(1, 6, 3);
        graph.insert(6, 4, 4);
        graph.insert(2, 4, 8);
        graph.insert(4, 5, 5);
        graph.insert(5, 3, 4);
        graph.insert(5, 6, 6);
        graph.print(graph.edges);
        graph.prime(graph, 0);

    }


}

class TGraph {
    public ArrayList<String> vertex;
    public int[][] edges;

    public int[][] insert(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        return edges;
    }

    public TGraph(int n) {
        vertex = new ArrayList<>(n);
        edges = new int[n][n];
    }

    /**
     * 二维矩阵打印
     *
     * @param edges
     */
    public void print(int[][] edges) {
        for (int[] ints : edges) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
    }

    public void prime(TGraph graph, int index) {
        //标记是否被访问
        int n = graph.vertex.size();
        int minWeight = 10000;
        int h1 = -1;
        int h2 = -1;
        boolean isVisited[] = new boolean[n];
        isVisited[index] = true;
        //最小生成树会有n-1条边，所以需要遍历n-1次
        for (int k = 1; k < n; k++) {
            //i表示已经访问过的结点位置
            for (int i = 0; i < n; i++) {
                //j表示还没访问过的结点位置
                for (int j = 0; j < n; j++) {
                    if (isVisited[i] && !isVisited[j] && graph.edges[i][j] != 0 && graph.edges[i][j] < minWeight) {
                        minWeight = graph.edges[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            System.out.println("访问(" + graph.vertex.get(h1) + "," + graph.vertex.get(h2) + "," + minWeight + ")");
            isVisited[h2] = true;
            minWeight = 10000;
        }
    }
}
