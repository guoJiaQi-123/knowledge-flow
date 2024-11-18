package com.dataStructure.leetcode;

/**
 * @author OldGj 2024/03/01
 * @version v1.0
 * @apiNote 11. 盛最多水的容器
 */
public class MostWaterLeetcode11 {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        // 每次让挡板低的向中间靠拢
        while (i < j) {
            if (height[i] < height[j]) {
                int area = (j - i) * height[i];
                max = Math.max(max, area);
                i++;
            } else {
                int area = (j - i) * height[j];
                max = Math.max(max, area);
                j--;
            }
        }
        return max;
    }
}
