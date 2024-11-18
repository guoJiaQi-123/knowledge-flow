package com.dataStructure.dataStructure.graph;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 迪杰斯特拉 - 最短路径算法 采用优先级队列选择最短距离顶点
 */
public class DijkstraPriorityQueue {

    public static void main(String[] args) {
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

        List<Vertex> graph = List.of(v1, v2, v3, v4, v5, v6);

        dijkstra(graph, v1);
    }


    /**
     * 迪杰斯特拉算法 - 计算图的最短路径
     *
     * @param graph 图
     * @param v     初始顶点
     */
    private static void dijkstra(List<Vertex> graph, Vertex v) {
        // 1.创建一个优先级队列（默认小顶堆），放入所有顶点（队列大小会达到边的数量）
        PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparing(vertex -> vertex.dict));
        for (Vertex vertex : graph) {
            queue.offer(vertex);
        }
        // 2.为每个顶点分配一个临时距离值
        // 2.1：对于初始顶点，临时距离值为0；
        v.dict = 0;
        while (!queue.isEmpty()) {
            // 3.选择最小临时距离的未访问顶点作为新的当前顶点
            Vertex curr = queue.peek();
            // 4.对于当前顶点，遍历其所有未访问的邻居，并更新它们的临时距离为更小，若距离更新需加入队列
            if (!curr.visited) {
                updateNeighboursDict(curr, queue);
                // 表示当前节点已被访问
                curr.visited = true;
            }
            // 5.当前顶点的邻居处理完成后，把它从未访问集合中删除
            queue.poll();
        }
        graph.forEach(vertex -> System.out.println(vertex.name + "::" + vertex.dict + "::" + (vertex.prev != null ? vertex.prev.name : "null")));
    }

    /**
     * 对于当前顶点，遍历其所有未访问的邻居，并更新它们的临时距离为更小，若距离更新需加入队列
     *
     * @param curr  当前顶点
     * @param queue 优先级【按照顶点距离】队列
     */
    private static void updateNeighboursDict(Vertex curr, PriorityQueue<Vertex> queue) {
        for (Edge edge : curr.edges) {
            // 获取邻居顶点
            Vertex neighbour = edge.linked;
            // 如果邻居顶点未访问（任然存在于未访问集合中）
            if (!neighbour.visited) {
                // 计算从当前顶点到邻居的距离
                int dict = curr.dict + edge.weight;
                // 如果这个距离小于之前邻居顶点中维护的距离值，则更新这个距离
                if (dict < neighbour.dict) {
                    neighbour.dict = dict;
                    neighbour.prev = curr;
                    // 更新距离需要加入队列
                    queue.offer(neighbour);
                }
            }
        }
    }

}
