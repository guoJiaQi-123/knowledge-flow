package com.dataStructure.dataStructure.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * 深度优先遍历
 */
public class DFS {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");

        v1.edges = List.of(
                new Edge(v2, 7),
                new Edge(v6, 14),
                new Edge(v3, 9)
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
        dfs2(v1);
    }

    /**
     * 深度优先遍历<递归实现>
     */
    public static void dfs(Vertex v) {
        // 当前节点设置为已被访问
        v.visited = true;
        // 消费当前节点
        System.out.println(v.name);
        // 遍历当前节点的相邻节点，如果相邻节点没有被访问，则递归执行
        for (Edge edge : v.edges) {
            if (!edge.linked.visited) {
                dfs(edge.linked);
            }
        }
    }

    /**
     * 深度优先遍历<非递归实现>
     */
    public static void dfs2(Vertex v) {
        // 非递归实现深度优先遍历需要栈数据结构
        LinkedList<Vertex> stack = new LinkedList<>();
        stack.push(v);
        while (!stack.isEmpty()) {
            Vertex pop = stack.pop();
            // 访问栈顶元素
            pop.visited = true;
            // 消费当前节点
            System.out.println(pop.name);
            // 遍历当前节点的相邻节点，如果相邻节点没有被访问，则加入栈中
            for (Edge edge : pop.edges) {
                if (!edge.linked.visited) {
                    stack.push(edge.linked);
                }
            }
        }
    }

}
