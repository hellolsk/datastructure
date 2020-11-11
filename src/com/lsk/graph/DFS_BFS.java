package com.lsk.graph;

/**
 * @Author:${六月的雨}
 * @Date:2020/10/28 10:17
 * @Description:20data_structure com.lsk.graph
 */
public class DFS_BFS {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        String[] s = {"1", "2", "3", "4", "5", "6", "7", "8"};
        //构造顶点
        for (String v : s) {
            graph.getVertex().add(v);
        }
        //构建边
        graph.insert(0, 1, 1);
        graph.insert(0, 2, 1);
        graph.insert(1, 3, 1);
        graph.insert(1, 4, 1);
        graph.insert(3, 7, 1);
        graph.insert(4, 7, 1);
        graph.insert(2, 5, 1);
        graph.insert(2, 6, 1);
        graph.insert(5, 6, 1);
        System.out.println("深度优先遍历：");
        graph.dfs(0);
        boolean[] isVisited = graph.getIsVisited();
        //需要将访问数组重置原始状态
        for (int i = 0; i < isVisited.length; i++) {
            isVisited[i] = false;
        }
        System.out.println("广度优先遍历：");
        graph.bfs(0);
    }
}
