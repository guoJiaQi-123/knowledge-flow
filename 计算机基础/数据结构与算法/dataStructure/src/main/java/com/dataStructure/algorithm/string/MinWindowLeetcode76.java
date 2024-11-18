package com.dataStructure.algorithm.string;

/**
 * @author OldGj 2024/03/03
 * @version v1.0
 * @apiNote 76. 最小覆盖子串
 */
public class MinWindowLeetcode76 {
    static class Result {
        int i;
        int j;

        public Result(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        String s = minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }

    /*
        1. 统计目标串需要各种字符个数， 统计原始串 i~j 范围各种字符个数
        2. 如果原始串 i~j 范围内不满足条件，j++ 扩大范围，直到满足条件 j 停下来
        3. 一旦满足条件 i++ 缩小范围，直到再次不满足条件 ...
        4. 重复 2. 3. 两步直至 j 到达原始串末尾
     */
    public static String minWindow(String s, String t) {

        /*
                a   b   c   target
                1   1   1   targetCount

                a d o b e c o d e b a n c   source
                i
                j

                1 1                         sourceCount

         */
        char[] target = t.toCharArray();
        int[] targetCount = new int[128];
        // 统计目标串中需要各种字符的个数
        for (char c : target) {
            targetCount[c]++;
        }
        // 统计需要满足的条件个数
        int passCount = 0;
        for (int i : targetCount) {
            if (i > 0) {
                passCount++;
            }
        }
        char[] source = s.toCharArray();
        // 统计原始串 i~j 范围各种字符的个数
        int[] sourceCount = new int[128];
        // 已经满足的条件数
        int passed = 0;
        int i = 0;
        int j = 0;
        Result result = null;
        while (j < source.length) {
            char right = source[j];
            // 统计原始串 i~j 范围各种字符的个数
            sourceCount[right]++;
            // 如果原始串中字符出现的次数等于目标串中字符出现的次数
            if (targetCount[right] == sourceCount[right]) {
                // 已经满足一个条件
                passed++;
            }
            // 如果已经满足条件个数等于需要满足的条件个数说明找到一个解
            while (i <= j && passed == passCount) { // 找到解
                // 找所有满足条件的解中，长度最小的
                if (result == null) {
                    result = new Result(i, j);
                } else {
                    if ((j - i) < (result.j - result.i)) {
                        result = new Result(i, j);
                    }
                }
                // 开始移动i，找长度更小的解
                char left = source[i];
                sourceCount[left]--;
                // 一旦原始串 i~j 范围各种字符的个数少于目标串中各种字符出现的次数
                if (sourceCount[left] < targetCount[left]) {
                    // 已经满足的条件被破坏，passed--
                    passed--;
                }
                i++;
            }
            j++;
        }

        return result == null ? "" : new String(source, result.i, result.j - result.i + 1);
    }
}
