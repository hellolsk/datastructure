package com.lsk.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author:${六月的雨}
 * @Date:2020/10/17 20:59
 * @Description:20data_structure com.lsk.graph
 */
public class Graph {
    //顶点集合
    private   ArrayList<String> vertex;
    //边的邻接矩阵
    private  int[][] edges;
    //记录边的个数
    private  int count;
    //记录每个结点是否被访问的数组
    private boolean[] isVisited;

    public ArrayList<String> getVertex() {
        return vertex;
    }

    public void setVertex(ArrayList<String> vertex) {
        this.vertex = vertex;
    }

    public int[][] getEdges() {
        return edges;
    }

    public void setEdges(int[][] edges) {
        this.edges = edges;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean[] getIsVisited() {
        return isVisited;
    }

    public void setIsVisited(boolean[] isVisited) {
        this.isVisited = isVisited;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        String[] values = {"A","B","C","D","E"};
        for(String v : values){
            graph.vertex.add(v);
        }
        graph.insert(0,1,1);
        graph.insert(0,2,1);
        graph.insert(1,2,1);
        graph.insert(1,3,1);
        graph.insert(1,4,1);
        System.out.println("顶点个数:"+graph.count);
        graph.print(graph.edges);
        //graph.dfs(0);
        graph.bfs(0);
    }
    /**
     * 构建图的方法
     * @param v1
     * @param v2
     * @param weight 1,代表可达；0,代表不可达
     */
    public  int[][] insert(int v1,int v2,int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        count++;;
        return edges;
    }

    /**
     * 得到第一个邻接结点的下标，没有就返回-1
     * @param index
     * @return
     */
    public int getFirstNeighbor(int index){
        for(int i=0;i<vertex.size();i++){
            if(edges[index][i]==1){
                return i;
            }
        }
        return -1;
    }

    /**
     * 根据前一邻接结点下标获取下一邻接结点
     * @param v1
     * @param v2
     * @return
     */
    public int getNeighbor(int v1,int v2){
        for(int j = v2+1;j<vertex.size();j++){
            if(edges[v1][j]==1){
                return j;
            }
        }
        return -1;
    }

    /**
     * 重载dfs,遍历所有结点
     * @param index
     */
    public void dfs(int index){
        for(int i = index;i<vertex.size();i++){
            if(!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }

    /**
     * 深度优先遍历
     * @param isVisited 每次遍历都需要判断是否被访问过
     * @param i 当前结点
     */
    private void dfs(boolean[] isVisited,int i){
        //输出访问的结点并标记
        System.out.print(getVertex(i)+"->");
        isVisited[i] = true;
        //找第一个邻接结点
        int w = getFirstNeighbor(i);
        //如果有循环，直到找不到或找完
        while (w!=-1){
            //没有被访问，则递归
            if(!isVisited[w]){
                dfs(isVisited,w);
            }
            //被访问过则选取下一个
            w = getNeighbor(i,w);
        }
    }

    /**
     * 重载，遍历所有结点。
     * @param index
     */
    public void bfs(int index){
        for(int i = index;i<vertex.size();i++){
            if(!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }

    /**
     * 广度优先遍历
     * @param isVisited
     * @param index
     */
    private void bfs(boolean[] isVisited, int index){
        //定义对头位置和邻接结点
        int u;
        int w;
        System.out.print(getVertex(index)+"->");
        isVisited[index] = true;
        //构造一个队列
        LinkedList queue = new LinkedList();
        queue.addLast(index);
        while (!queue.isEmpty()){
            //出队
             u = (Integer) queue.removeFirst();
             w = getFirstNeighbor(u);
             while(w!=-1){
                 if(!isVisited[w]){
                     System.out.print(getVertex(w)+"->");
                     isVisited[w] = true;
                     queue.addLast(w);
                 }
                 w = getNeighbor(u,w);
             }
        }
    }

    /**
     * 打印图的邻接矩阵
     * @param args
     */
    public void print(int[][] args){
        for(int[] arg : args){
            System.out.println(Arrays.toString(arg));
        }
        System.out.println();
    }
    //根据索引获取顶点值
    public String getVertex(int index){
        return vertex.get(index);
    }
    //构造器初始化
    public Graph(int n){
        vertex = new ArrayList<>(n);
        edges = new int[n][n];
        isVisited = new boolean[n];
    }

    /**
     * 普瑞姆算法求解最小生成树
     *
     * @param graph
     * @param index
     */
    public void prime(Graph graph, int index) {
        //标记是否被访问
        int n = graph.getVertex().size();
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
                    if (isVisited[i] && !isVisited[j] && graph.getEdges()[i][j] < minWeight && graph.getEdges()[i][j] != 0) {
                        minWeight = graph.getEdges()[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            System.out.println("访问(" + graph.getVertex(h1) + "," + graph.getVertex(h2) + "," + minWeight + ")");
            isVisited[h2] = true;
            minWeight = 10000;
        }
    }
}
