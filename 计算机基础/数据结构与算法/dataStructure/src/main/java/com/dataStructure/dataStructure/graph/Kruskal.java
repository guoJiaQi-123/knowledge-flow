package com.dataStructure.dataStructure.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 最小生成树 - Kruskal(克鲁斯克拉算法) 从边着手
 */
public class Kruskal {

    /**
     * 边对象
     */
    static class Edge implements Comparable<Edge> {
        List<Vertex> vertices;
        int start;
        int end;
        int weight;

        public Edge(List<Vertex> vertices, int start, int end, int weight) {
            this.vertices = vertices;
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }

        @Override
        public String toString() {
            return vertices.get(start).name + "<->" + vertices.get(end).name + "(" + weight + ")";
        }
    }

    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");
        Vertex v7 = new Vertex("v7");

        List<Vertex> vertices = List.of(v1, v2, v3, v4, v5, v6, v7);
        PriorityQueue<Edge> queue = new PriorityQueue<>(List.of(
                new Edge(vertices, 0, 1, 2),
                new Edge(vertices, 0, 2, 4),
                new Edge(vertices, 0, 3, 1),
                new Edge(vertices, 1, 3, 3),
                new Edge(vertices, 1, 4, 10),
                new Edge(vertices, 2, 3, 2),
                new Edge(vertices, 2, 5, 5),
                new Edge(vertices, 3, 4, 7),
                new Edge(vertices, 3, 5, 8),
                new Edge(vertices, 3, 6, 4),
                new Edge(vertices, 4, 6, 6),
                new Edge(vertices, 5, 6, 1)
        ));

        kruskal(vertices.size(), queue);
    }

    /**
     * 最小生成树 - Kruskal 算法
     *
     * @param size  顶点个数
     * @param queue 以边的权重为参考的优先级队列
     */
    private static void kruskal(int size, PriorityQueue<Edge> queue) {
        List<Edge> result = new ArrayList<>();
        // 并查集
        DisJoinSet set = new DisJoinSet(size);
        // 最小生成树的结果集合的边的个数应该等于顶点个数-1
        while (result.size() < size - 1) {
            Edge poll = queue.poll();
            int x = set.find(poll.start);
            int y = set.find(poll.end);
            // 不连通
            if (x != y) {
                result.add(poll);
                set.union(x, y);
            }
        }
        for (Edge edge : result) {
            System.out.println(edge);
        }
    }
}
