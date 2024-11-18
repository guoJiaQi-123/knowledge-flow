package com.dataStructure.algorithm.greedy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 哈夫曼树
 */
public class HuffmanTree {

    /*
        Huffman 树的构建过程

        1. 将统计了出现频率的字符，放入优先级队列

        2. 每次出队两个频次最低的元素，给它俩找个爹
        3. 把爹重新放入队列，重复 2~3
        4. 当队列只剩一个元素时，Huffman 树构建完成
     */

    static class Node {
        Character ch;
        int freq;
        Node left;
        Node right;
        String code;  // 编码

        public Node(Character ch) {
            this.ch = ch;
        }

        public Node(int freq, Node left, Node right) {
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        public boolean isLeaf() {
            return left == null;
        }

        public int freq() {
            return this.freq;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "ch=" + ch +
                    ", freq=" + freq +
                    '}';
        }
    }

    String str;
    HashMap<Character, Node> map = new HashMap<>();
    Node root;

    public HuffmanTree(String str) {
        this.str = str;
        // 功能1：统计频率
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            Node node = map.computeIfAbsent(c, Node::new);
            node.freq++;
        }
        // 功能2：构造树
        PriorityQueue<Node> queue = new PriorityQueue<>(
                Comparator.comparingInt(Node::freq)
        );
        queue.addAll(map.values());
        while (queue.size() >= 2) {
            // 每次出队两个频次最低的元素，给他俩找个爹
            Node x = queue.poll();
            Node y = queue.poll();
            int freq = x.freq + y.freq;
            // 把爹重新放到优先级队列中
            queue.offer(new Node(freq, x, y));
        }
        // 当队列只剩一个节点时，Huffman树构建成功
        root = queue.poll(); // Huffman树根节点
        // 功能3：计算每个字符的编码, 功能4：字符串编码后占用 bits
        int bits = dfs(root, new StringBuilder());
        System.out.println(bits);
    }

    /**
     * 深度优先遍历
     *
     * @param node 根节点
     * @param code 编码
     * @return 字符串编码后占用 bits
     */
    private int dfs(Node node, StringBuilder code) {
        int sum = 0;
        if (node.isLeaf()) {
            node.code = code.toString();
            sum = node.freq * code.length();
        } else {
            sum += dfs(node.left, code.append("0"));
            sum += dfs(node.right, code.append("1"));
        }
        if (code.length() > 0) {
            code.deleteCharAt(code.length() - 1);
        }
        return sum;
    }

    /**
     * 编码
     *
     * @return 对字符串编码后的位
     */
    public String encode() {
        StringBuilder sb = new StringBuilder();
        char[] ch = str.toCharArray();
        for (char c : ch) {
            Node node = map.get(c);
            String code = node.code;
            sb.append(code);
        }
        return sb.toString();
    }

    /**
     * 解码
     *
     * @param str 待解码位
     * @return 解码后的字符串
     */
    public String decode(String str) { //0001011111111
        char[] ch = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        Node node = root;
        int i = 0;
        while (i < ch.length) {
            if (!node.isLeaf()) { // 非叶子节点
                if (ch[i] == '0') {
                    node = node.left;
                    i++;
                } else if (ch[i] == '1') {
                    node = node.right;
                    i++;
                }
            }
            if (node.isLeaf()) { // 叶子节点
                sb.append(node.ch);
                node = root;
            }
        }
        return sb.toString();
    }
}
