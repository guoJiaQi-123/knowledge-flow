package com.dataStructure.dataStructure.graph;

import java.util.List;
import java.util.Objects;

/**
 * 顶点
 */
public class Vertex {

    String name;

    List<Edge> edges;

    // 顶点入度
    int inDegree;

    // 标志该顶点是否被访问过 用于DFS和BFS判断
    boolean visited;

    // 标志该顶点状态 0：未访问  1：访问中  2：已访问
    int status;

    // 初始化距离 - dijkstra算法
    int dict = INF;
    static final Integer INF = Integer.MAX_VALUE; // 初始化距离为无穷大
    // dijkstra算法中记录路径，当前节点的上一个节点
    Vertex prev = null;

    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(name, vertex.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
