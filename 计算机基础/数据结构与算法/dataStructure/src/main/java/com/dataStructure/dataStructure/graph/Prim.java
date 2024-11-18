package com.dataStructure.dataStructure.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 最小生成树 - Prim算法 以顶点着手
 */
public class Prim {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");
        Vertex v7 = new Vertex("v7");

        v1.edges = List.of(new Edge(v2, 2), new Edge(v3, 4), new Edge(v4, 1));
        v2.edges = List.of(new Edge(v1, 2), new Edge(v4, 3), new Edge(v5, 10));
        v3.edges = List.of(new Edge(v1, 4), new Edge(v4, 2), new Edge(v6, 5));
        v4.edges = List.of(new Edge(v1, 1), new Edge(v2, 3), new Edge(v3, 2),
                new Edge(v5, 7), new Edge(v6, 8), new Edge(v7, 4));
        v5.edges = List.of(new Edge(v2, 10), new Edge(v4, 7), new Edge(v7, 6));
        v6.edges = List.of(new Edge(v3, 5), new Edge(v4, 8), new Edge(v7, 1));
        v7.edges = List.of(new Edge(v4, 4), new Edge(v5, 6), new Edge(v6, 1));

        List<Vertex> graph = List.of(v1, v2, v3, v4, v5, v6, v7);

        prim(graph, v1);

    }

    private static void prim(List<Vertex> graph, Vertex v) {
        // 1.将所有顶点标记为未访问，创建一个未访问顶点的集合
        List<Vertex> list = new ArrayList<>(graph);
        // 2.为每个顶点分配一个临时距离值
        // 2.1：对于初始顶点，临时距离值为0；
        v.dict = 0;
        while (!list.isEmpty()) {
            // 3.选择最小临时距离的未访问顶点作为新的当前顶点
            Vertex curr = chooseMinDictVertex(list);
            // 4.对于当前顶点，遍历所有未访问的邻居，并更新它们的临时距离为更小
            updateNeighboursDict(curr);
            // 5.当前顶点的邻居处理完成后，把它从未访问集合中删除
            list.remove(curr);
            // 表示当前节点已被访问
            curr.visited = true;
        }
        for (Vertex vertex : graph) {
            System.out.println(vertex.getName() + "::" + (vertex.prev != null ?vertex.prev.name:"null"));
        }
    }
    /**
     * 对于当前顶点，遍历所有未访问的邻居，并更新它们的临时距离为更小
     *
     * @param curr 当前顶点
     */
    private static void updateNeighboursDict(Vertex curr) {
        for (Edge edge : curr.edges) {
            // 获取邻居顶点
            Vertex neighbour = edge.linked;
            // 如果邻居顶点未访问（任然存在于未访问集合中）
            if (!neighbour.visited) {
                // 计算从当前顶点到邻居的距离
                int dict = edge.weight;
                // 如果这个距离小于之前邻居顶点中维护的距离值，则更新这个距离
                if (dict < neighbour.dict) {
                    neighbour.dict = dict;
                    neighbour.prev = curr;
                }
            }
        }
    }

    /**
     * 选择最小临时距离的未访问顶点作为新的当前顶点
     *
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
