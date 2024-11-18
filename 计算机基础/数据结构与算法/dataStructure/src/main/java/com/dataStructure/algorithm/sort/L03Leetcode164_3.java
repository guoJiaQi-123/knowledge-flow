package com.dataStructure.algorithm.sort;

/**
 * 164. 最大间距 Pair
 */
public class L03Leetcode164_3 {
    public static int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int range = Math.max((max - min) / nums.length, 1);
        Pair[] buckets = new Pair[(max - min) / range + 1];


        for (int num : nums) {
            int idx = (num - min) / range;
            if (buckets[idx] == null) {
                buckets[idx] = new Pair();
            }
            buckets[idx].add(num);
        }

        for (Pair bucket : buckets) {
            System.out.println(bucket);
        }

        int r = 0;
        int lastMax = buckets[0].max;
        for (int i = 1; i < buckets.length; i++) {
            Pair bucket = buckets[i];
            if (bucket != null) {
                r = Math.max(r, bucket.min - lastMax);
                lastMax = bucket.max;
            }
        }
        return r;

    }

    static class Pair {
        int max = 0;
        int min = 1000_000_000;

        public void add(int v) {
            max = Math.max(v, max);
            min = Math.min(v, min);
        }

        @Override
        public String toString() {
            return "[" + max +
                    ", " + min +
                    ']';
        }
    }

}
