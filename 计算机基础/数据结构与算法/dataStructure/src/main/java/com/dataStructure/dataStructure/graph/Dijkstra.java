package com.dataStructure.dataStructure.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 迪杰斯特拉 - 单源最短路径问题
 */
public class Dijkstra {
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
        // 1.将所有顶点标记为未访问，创建一个未访问顶点的集合
        List<Vertex> list = new ArrayList<>(graph);
        // 2.为每个顶点分配一个临时距离值
        // 2.1：对于初始顶点，临时距离值为0；
        v.dict = 0;
        while (!list.isEmpty()) {
            // 3.选择最小临时距离的未访问顶点作为新的当前顶点【选取当前节点】
            Vertex curr = chooseMinDictVertex(list);
            // 4.对于当前顶点，遍历所有未访问的邻居，并更新它们的临时距离为更小
            updateNeighboursDict(curr);
            // 5.当前顶点的邻居处理完成后，把它从未访问集合中删除
            list.remove(curr);
            // 表示当前节点已被访问
            curr.visited = true;
        }
        for (Vertex vertex : graph) {
            System.out.println(vertex.getName() + "::" + vertex.dict + "::" + (vertex.prev != null ? vertex.prev.name : "null"));
        }
    }

    /**
     * 对于当前顶点，遍历所有未访问的邻居，并更新它们的临时距离为更小
     * @param curr 当前顶点
     */
    private static void updateNeighboursDict(Vertex curr) {
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
                    // 记录当前节点的路径从何而来
                    neighbour.prev = curr;
                }
            }
        }
    }

    /**
     * 选择最小临时距离的未访问顶点作为新的当前顶点
     * @param list 未访问顶点集合
     * @return 临时距离最小的顶点
     */
    private static Vertex chooseMinDictVertex(List<Vertex> list) {
        // 默认未访问顶点集合中第一个顶点的距离最小
        Vertex min = list.get(0);
        // 遍历未访问顶点集合，如果发现有距离更小的顶点，则更新距离最小的顶点引用
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).dict < min.dict) {
                min = list.get(i);
            }
        }
        return min;
    }
}
