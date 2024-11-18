package com.dataStructure.dataStructure.graph;

/**
 * 边
 */
public class Edge {

    // 顶点
    Vertex linked;

    // 权重
    int weight;

    public Edge(Vertex linked) {
        this(linked, 1);
    }

    public Edge(Vertex linked, int weight) {
        this.linked = linked;
        this.weight = weight;
    }
}
