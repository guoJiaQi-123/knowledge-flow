package com.dataStructure.dataStructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 拓扑排序
 */
public class TopologicalSort {

    public static void main(String[] args) {
        Vertex v1 = new Vertex("网页基础");
        Vertex v2 = new Vertex("Java基础");
        Vertex v3 = new Vertex("JavaWeb");
        Vertex v4 = new Vertex("Spring框架");
        Vertex v5 = new Vertex("微服务框架");
        Vertex v6 = new Vertex("数据库");
        Vertex v7 = new Vertex("实战项目");

        v1.edges = List.of(new Edge(v3)); // +1
        v2.edges = List.of(new Edge(v3)); // +1
        v3.edges = List.of(new Edge(v4));
        v6.edges = List.of(new Edge(v4));
        v4.edges = List.of(new Edge(v5));
        v5.edges = List.of(new Edge(v7));
        v7.edges = List.of();

        List<Vertex> graph = List.of(v1, v2, v3, v4, v5, v6, v7);
        // 对graph图进行拓扑排序
        topologicalSort(graph);
    }

    /**
     * 拓扑排序
     * @param graph 待排序图
     */
    private static void topologicalSort(List<Vertex> graph) {
        // 1. 统计每个顶点的入度
        for (Vertex v : graph) { // 遍历图中的每个订单
            for (Edge edge : v.edges) { // 遍历订单的所有边
                edge.linked.inDegree++; // 将相邻顶点的入度+1
            }
        }
        // 2. 将入度为0的顶点加入队列
        LinkedList<Vertex> queue = new LinkedList<>();
        for (Vertex v : graph) {
            if (v.inDegree == 0) {
                queue.offer(v);
            }
        }
        // 3. 队列中不断移除顶点，每移除一个顶点，把它相邻顶点入度减1，若减到0则入队
        // 定义一个ArrayList用于存放拓扑排序后的结果
        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Vertex poll = queue.poll();
            // 每次从队列中移除的顶点放入结果集合中
            result.add(poll.name);
            for (Edge edge : poll.edges) {
                edge.linked.inDegree--;
                if (edge.linked.inDegree == 0) {
                    queue.offer(edge.linked); // 若相邻节点入度减到0则入队
                }
            }
        }
        // 判断是否存在环：如果结果集合中的顶点个数小于图中顶点个数，则说明存在环
        if (result.size() != graph.size()) {
            // 存在环
            System.out.println("图中存在环");
        } else {
            // 不存在环，输出结果集合中的元素
            for (String key : result) {
                System.out.println(key);
            }
        }
    }
}
