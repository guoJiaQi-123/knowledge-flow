package com.dataStructure.algorithm.dynamicprogramming;

import com.dataStructure.dataStructure.graph.Vertex;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author HX 2024/02/19
 * @version v1.0
 * @apiNote BellmanFold - 动态规划解法
 */
public class BellmanFold {

    static class Edge {
        private int from;
        private int to;
        private int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

    }

    public static void main(String[] args) {
        List<Edge> edges = List.of(
                new Edge(6, 5, 9),
                new Edge(4, 5, 6),
                new Edge(1, 6, 14),
                new Edge(3, 6, 2),
                new Edge(3, 4, 11),
                new Edge(2, 4, 15),
                new Edge(1, 3, 9),
                new Edge(1, 2, 7)
        );

        bellmanFold(edges, 6);
    }

    /*
            f(v) 用来表示从起点出发，到达 v 这个顶点的最短距离
            初始时
            f(v) = 0   当 v==起点 时
            f(v) = ∞   当 v!=起点 时

            之后
            新           旧     所有from
            f(to) = min(f(to), f(from) + from.weight)

            from 从哪来
            to   到哪去

            f(v4) = min( ∞, f(v3) + 11 ) = 20
            f(v4) = min( 20, f(v2) + 15 ) = 20


            v1  v2  v3  v4  v5  v6
            0   ∞   ∞   ∞   ∞   ∞
            0   7   9   ∞   ∞   14  第一轮
            0   7   9   20  23  11  第二轮
            0   7   9   20  20  11  第三轮
            0   7   9   20  20  11  第四轮
            0   7   9   20  20  11  第五轮

     */


    /**
     * bellmanFold算法计算最短路径 - 动态规划
     *
     * @param edges 所有边
     * @param n     顶点个数
     */
    private static void bellmanFold(List<Edge> edges, int n) {
        // 创建一个一维数组存储每个顶点的最短路径
        int[] dp = new int[n + 1];
        // 初始化
        dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        // 进行n-1轮操作，每轮操作拿到所有的边，查看边的起点是否由最短路径可达
        // 如果可达，计算边的终点的最短路径是否为起点加当前边的权重
        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                if (dp[edge.from] != Integer.MAX_VALUE) {
                    dp[edge.to] = Integer.min(dp[edge.to], (dp[edge.from] + edge.weight));
                }
            }
        }
        print(dp);
    }

    static void print(int[] dp) {
        System.out.println(Arrays.stream(dp)
                .mapToObj(i -> i == Integer.MAX_VALUE ? "∞" : String.valueOf(i))
                .collect(Collectors.joining(",", "[", "]")));
    }
}
