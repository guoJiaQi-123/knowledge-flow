package com.dataStructure.dataStructure.redblacktree;



import com.dataStructure.dataStructure.redblacktree.MyRedBlackTree2.RedBlackNode2;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;
import static com.dataStructure.dataStructure.redblacktree.MyRedBlackTree2.Color.BLACK;
import static com.dataStructure.dataStructure.redblacktree.MyRedBlackTree2.Color.RED;
import static org.junit.jupiter.api.Assertions.*;


class TestMyRedBlackTree2 {

    @Test
    void put() {
        MyRedBlackTree2 tree = new MyRedBlackTree2();
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
        MyRedBlackTree2 tree = new MyRedBlackTree2();
        tree.root = new RedBlackNode2(8, BLACK,
                new RedBlackNode2(4, BLACK,
                        new RedBlackNode2(2, RED, new RedBlackNode2(1, BLACK), new RedBlackNode2(3, BLACK)),
                        new RedBlackNode2(6, RED, new RedBlackNode2(5, BLACK), new RedBlackNode2(7, BLACK))),
                new RedBlackNode2(12, BLACK,
                        new RedBlackNode2(10, RED, new RedBlackNode2(9, BLACK), new RedBlackNode2(11, BLACK)),
                        new RedBlackNode2(14, RED, new RedBlackNode2(13, BLACK), new RedBlackNode2(15, BLACK))
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
        MyRedBlackTree2 tree = new MyRedBlackTree2();
        tree.root = new RedBlackNode2(8, BLACK,
                new RedBlackNode2(4, BLACK,
                        new RedBlackNode2(2, RED, new RedBlackNode2(1, BLACK), new RedBlackNode2(3, BLACK)),
                        new RedBlackNode2(6, RED, new RedBlackNode2(5, BLACK), new RedBlackNode2(7, BLACK))),
                new RedBlackNode2(12, BLACK,
                        new RedBlackNode2(10, RED, new RedBlackNode2(9, BLACK), new RedBlackNode2(11, BLACK)),
                        new RedBlackNode2(14, RED, new RedBlackNode2(13, BLACK), new RedBlackNode2(15, BLACK))
                )
        );
        isValid(tree);
    }

    private void isValid(MyRedBlackTree2 tree) {
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
            RedBlackNode2 parent, RedBlackNode2 RedBlackNode2, int thisHeight, MutableHeight height) {
        // 规则5 每条路径黑色相等 RedBlackNode2 == null 表示一条路径走到头
        if (RedBlackNode2 == null) {
            // First NIL RedBlackNode2?
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

        // Count black RedBlackNode2s on path
        if (RedBlackNode2.color == BLACK) {
            thisHeight++;
        }

        // 规则3 红色不相邻
        else if (parent != null && parent.color == RED) {
            throw new AssertionError("RedBlackNode " + RedBlackNode2.key + " and its parent " + parent.key + " are both red");
        }

        // We're using the simplified approach of not forcing the root to be black
        validateRedBlackInvariant(RedBlackNode2, RedBlackNode2.left, thisHeight, height);
        validateRedBlackInvariant(RedBlackNode2, RedBlackNode2.right, thisHeight, height);
    }
}