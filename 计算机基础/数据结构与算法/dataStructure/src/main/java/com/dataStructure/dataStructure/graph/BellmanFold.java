package com.dataStructure.dataStructure.graph;

import java.util.List;

/**
 * BellmanFold算法 - 可处理负权重
 */
public class BellmanFold {
    public static void main(String[] args) {
        // 正常情况
/*
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");

        v1.edges = List.of(new Edge(v3, 9), new Edge(v2, 7), new Edge(v6, 14));
        v2.edges = List.of(new Edge(v4, 15));
        v3.edges = List.of(new Edge(v4, 11), new Edge(v6, 2));
        v4.edges = List.of(new Edge(v5, 6));
        v5.edges = List.of();
        v6.edges = List.of(new Edge(v5, 9));

        List<Vertex> graph = List.of(v4, v5, v6, v1, v2, v3);
*/

        // 负边情况
/*
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");

        v1.edges = List.of(new Edge(v2, 2), new Edge(v3, 1));
        v2.edges = List.of(new Edge(v3, -2));
        v3.edges = List.of(new Edge(v4, 1));
        v4.edges = List.of();
        List<Vertex> graph = List.of(v1, v2, v3, v4);
*/

        // 负环情况
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");

        v1.edges = List.of(new Edge(v2, 2));
        v2.edges = List.of(new Edge(v3, -4));
        v3.edges = List.of(new Edge(v4, 1), new Edge(v1, 1));
        v4.edges = List.of();
        List<Vertex> graph = List.of(v1, v2, v3, v4);

        bellmanFord(graph, v1);
    }

    /**
     * 贝尔曼-福德算法 —— 用于处理有负权重的图的最短路径问题
     * @param graph 图
     * @param source 初始顶点
     */
    private static void bellmanFord(List<Vertex> graph, Vertex source) {
        // 将源点的最短路径长度估计值设置为0
        source.dict = 0;
        int size = graph.size();
        // 1. 进行 顶点个数 - 1 轮处理
        for (int i = 0; i < size - 1; i++) {
            // 2. 遍历所有的边
            for (Vertex s : graph) {
                for (Edge edge : s.edges) {
                    // 3. 处理每一条边
                    Vertex e = edge.linked;
                    if (s.dict != Integer.MAX_VALUE && s.dict + edge.weight < e.dict) {
                        e.dict = s.dict + edge.weight;
                        e.prev = s;
                    }
                }
            }
        }
        // 对于每一条边，再进行一次松弛操作。如果在这一轮中仍然存在可以缩短路径长度的情况，则说明图中存在负权环。
        for (Vertex s : graph) {
            for (Edge edge : s.edges) {
                Vertex e = edge.linked;
                if (s.dict != Integer.MAX_VALUE && s.dict + edge.weight < e.dict) {
                    throw new RuntimeException("出现负环");
                }
            }
        }
        graph.forEach(vertex -> System.out.println(vertex.name+"::"+vertex.dict+"::"+(vertex.prev!=null?vertex.prev.name:"null")));
    }
}
