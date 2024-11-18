package com.dataStructure.dataStructure.graph;

import java.util.Arrays;

/**
 * 不相交集合（并查集）
 */
public class DisJoinSet {

    int[] s;
    int[] size;

    // 索引对应顶点
    // 元素是用来表示与之有关系的顶点
    /*
        索引  0  1  2  3  4  5  6
        元素 [0, 1, 2, 3, 4, 5, 6] 表示一开始顶点直接没有联系（只与自己有联系）

    */
    public DisJoinSet(int size) {
        s = new int[size];
        this.size = new int[size];
        // 初始化数组中的值和索引是一样的
        for (int i = 0; i < size; i++) {
            s[i] = i;
            this.size[i] = 1;
        }
    }

    // find 是找到老大  老大：索引和值相等
    public int find(int x) {
        // 值和索引一样的为老大
        if (x == s[x]) {
            return x;
        }
        return s[x] = find(s[x]); // 优化1：路径压缩 将小弟的值直接修改为找到的老大的索引
    }

    // union 是让两个集合“相交”，即选出新老大，x、y 是原老大索引
    // 优化2：union by size 始终让顶点个数小的集合的老大认顶点个数多的集合的老大为老大
    public void union(int x, int y) {
        if (size[x] < size[y]) {
            // 小弟的值跟随老大
            s[x] = y;
            // 老大的小弟为 原有小弟+新认小弟的原有小弟
            size[y] = size[y]+size[x];
        }else {
            // 小弟的值跟随老大
            s[y] = x;
            size[x] = size[y]+size[x];
        }

    }

    @Override
    public String toString() {
        return Arrays.toString(s);
    }
}
