package com.dataStructure.dataStructure.redblacktree;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;
import com.dataStructure.dataStructure.redblacktree.RedBlackTree.RedBlackNode;
import static org.junit.jupiter.api.Assertions.*;
import static com.dataStructure.dataStructure.redblacktree.RedBlackTree.Color.RED;
import static com.dataStructure.dataStructure.redblacktree.RedBlackTree.Color.BLACK;


class TestRedBlackTree {

    @Test
    void put() {
        RedBlackTree tree = new RedBlackTree();
        ThreadLocalRandom random = ThreadLocalRandom.current();
        ArrayList<Integer> keys = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            int key = random.nextInt();
            keys.add(key);
            tree.put(key, null);
            assertTrue(tree.contains(key));
            isValid(tree);
        }

        for (Integer key : keys) {
            tree.remove(key);
            assertFalse(tree.contains(key));
            isValid(tree);
        }

        assertNull(tree.root);
    }

    @Test
    void remove() {
        RedBlackTree tree = new RedBlackTree();
        tree.root = new RedBlackNode(8, BLACK,
                new RedBlackNode(4, BLACK,
                        new RedBlackNode(2, RED, new RedBlackNode(1, BLACK), new RedBlackNode(3, BLACK)),
                        new RedBlackNode(6, RED, new RedBlackNode(5, BLACK), new RedBlackNode(7, BLACK))),
                new RedBlackNode(12, BLACK,
                        new RedBlackNode(10, RED, new RedBlackNode(9, BLACK), new RedBlackNode(11, BLACK)),
                        new RedBlackNode(14, RED, new RedBlackNode(13, BLACK), new RedBlackNode(15, BLACK))
                )
        );
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
        Collections.shuffle(list);
        for (Integer key : list) {
            tree.remove(key);
            assertFalse(tree.contains(key));
            isValid(tree);
        }
        assertNull(tree.root);
    }

    @Test
    void test() {
        RedBlackTree tree = new RedBlackTree();
        tree.root = new RedBlackNode(8, BLACK,
                new RedBlackNode(4, BLACK,
                        new RedBlackNode(2, RED, new RedBlackNode(1, BLACK), new RedBlackNode(3, BLACK)),
                        new RedBlackNode(6, RED, new RedBlackNode(5, BLACK), new RedBlackNode(7, BLACK))),
                new RedBlackNode(12, BLACK,
                        new RedBlackNode(10, RED, new RedBlackNode(9, BLACK), new RedBlackNode(11, BLACK)),
                        new RedBlackNode(14, RED, new RedBlackNode(13, BLACK), new RedBlackNode(15, BLACK))
                )
        );
        isValid(tree);
    }

    private void isValid(RedBlackTree tree) {
        if (tree.root == null) {
            return;
        }
        // 规则 4 根节点必须是黑
        if (tree.root.color != BLACK) {
            throw new AssertionError("root's color must BLACK");
        }
        validateRedBlackInvariant(null, tree.root, 0, new MutableHeight());
    }

    private static class MutableHeight {
        private Integer value;
    }

    private void validateRedBlackInvariant(
            RedBlackNode parent, RedBlackNode RedBlackNode, int thisHeight, MutableHeight height) {
        // 规则5 每条路径黑色相等 RedBlackNode == null 表示一条路径走到头
        if (RedBlackNode == null) {
            // First NIL RedBlackNode?
            if (height.value == null) {
                height.value = thisHeight;
            } else if (height.value != thisHeight) {
                throw new AssertionError(
                        "Black-height rule violated (height.value = "
                                + height.value
                                + "; thisHeight = "
                                + thisHeight
                                + "; parent = "
                                + parent.key
                                + ")");
            }
            return;
        }

        // Count black RedBlackNodes on path
        if (RedBlackNode.color == BLACK) {
            thisHeight++;
        }

        // 规则3 红色不相邻
        else if (parent != null && parent.color == RED) {
            throw new AssertionError("RedBlackNode " + RedBlackNode.key + " and its parent " + parent.key + " are both red");
        }

        // We're using the simplified approach of not forcing the root to be black
        validateRedBlackInvariant(RedBlackNode, RedBlackNode.left, thisHeight, height);
        validateRedBlackInvariant(RedBlackNode, RedBlackNode.right, thisHeight, height);
    }
}