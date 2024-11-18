package com.dataStructure.dataStructure.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * 广度优先遍历
 */
public class BFS {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");

        v1.edges = List.of(
                new Edge(v3, 9),
                new Edge(v2, 7),
                new Edge(v6, 14)
        );

        v2.edges = List.of(
                new Edge(v4, 15)
        );

        v3.edges = List.of(
                new Edge(v6, 2),
                new Edge(v4, 11)
        );

        v4.edges = List.of(
                new Edge(v5, 6)
        );

        v5.edges = List.of();

        v6.edges = List.of(
                new Edge(v5, 9)
        );
        bfs(v1);
    }

    /**
     * 广度优先遍历
     */
    private static void bfs(Vertex v) {
        // 实现广度优先遍历需要队列数据结构
        LinkedList<Vertex> queue = new LinkedList<>();
        // 起点v入队
        queue.offer(v);
        v.visited = true;
        while (!queue.isEmpty()) {
            Vertex poll = queue.poll();
            System.out.println(poll.name); // 消费节点
            // 遍历相邻节点，如果相邻节点没有被访问过，则设置为已访问并且加入队列
            for (Edge edge : poll.edges) {
                if (!edge.linked.visited) {
                    edge.linked.visited = true;
                    queue.offer(edge.linked);
                }
            }
        }
    }
}
