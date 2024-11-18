package com.dataStructure.dataStructure.graph;

import java.util.List;
import java.util.Stack;

/**
 * 拓扑排序 - DFS实现
 */
public class TopologicalSortDFS {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("网页基础");
        Vertex v2 = new Vertex("Java基础");
        Vertex v3 = new Vertex("JavaWeb");
        Vertex v4 = new Vertex("Spring框架");
        Vertex v5 = new Vertex("微服务框架");
        Vertex v6 = new Vertex("数据库");
        Vertex v7 = new Vertex("实战项目");

        v1.edges = List.of(new Edge(v3));
        v2.edges = List.of(new Edge(v3));
        v3.edges = List.of(new Edge(v4));
        v6.edges = List.of(new Edge(v4));
        v4.edges = List.of(new Edge(v5));
        v5.edges = List.of(new Edge(v7));
        v7.edges = List.of();

        List<Vertex> graph = List.of(v1, v2, v3, v4, v5, v6, v7);
        topologicalSortDFS(graph);
    }

    /**
     * 拓扑排序-DFS法
     * @param graph 待排序图
     */
    private static void topologicalSortDFS(List<Vertex> graph) {
        Stack<String> stack = new Stack<>();
        for (Vertex vertex : graph) {
            dfs(vertex, stack);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + '\t');
        }
    }

    private static void dfs(Vertex v, Stack<String> stack) {
        //如果当前节点已经被访问过，则直接返回
        if (v.status == 2) {
            return;
        }
        // 如果在递归过程中，发现当前节点的状态为1，说明当前节点本身还没处理完，就又有节点指向了当前节点，说明图中存在环
        if (v.status == 1) {
            throw new RuntimeException("出现环");
        }
        v.status = 1; // 在处理当前节点的相邻节点的过程中，将当前节点的状态设置为1，表示当前节点还没有处理完成
        // 遍历当前节点的相邻节点，递归执行
        for (Edge edge : v.edges) {
            dfs(edge.linked, stack);
        }
        // 当前节点的所有相邻节点都处理完成后，将当前节点状态设置为2，并且压栈
        v.status = 2;
        stack.push(v.name);
    }
}
