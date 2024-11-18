package com.dataStructure.algorithm.greedy;


import java.util.*;
import java.util.stream.Collectors;

/**
 * <b>选择活动问题 - 贪心解法</b><br/>
 *  LeetCode 435 无重复区间本质就是活动选择问题
 */
public class ActivitySelectionProblem {

    /*
        要在一个会议室举办 n 个活动
        - 每个活动有它们各自的起始和结束时间
        - 找出在时间上互不冲突的活动组合，能够最充分利用会议室（举办的活动次数最多）

        例1
            0   1   2   3   4   5   6   7   8   9
                |-------)
                    |-------)
                        |-------)
        例2
            0   1   2   3   4   5   6   7   8   9
                |---)
                        |---)
            |-----------------------)
                                |-------)
                                            |---)
                                |---------------)





        几种贪心策略
        1. 优先选择持续时间最短的活动
            0   1   2   3   4   5   6   7   8   9
                |---------------)
                            |-------)
                                |---------------)

        2. 优先选择冲突最少的活动
            0   1   2   3   4   5   6   7   8   9
            |-------)                                       3
                |-------)                                   4
                |-------)                                   4
                |-------)                                   4
                    |-------)                               4
                        |-------)                           2
                            |-----------)                   4
                                    |-------)               4
                                    |-------)               4
                                    |-------)               4
                                        |-------)           3

        3. 优先选择最先开始的活动
            0   1   2   3   4   5   6   7   8   9
            |-----------------------------------)
                |---)
                    |---)
                        |---)

        4. 优先选择最后结束的活动
     */

    /**
     * 活动实体类
     */
    static class Activity {
        int index; // 活动编号
        int start; // 活动开始时间
        int finish; // 活动结束时间

        public Activity(int index, int start, int finish) {
            this.index = index;
            this.start = start;
            this.finish = finish;
        }

        @Override
        public String toString() {
            return "Activity{" +
                    "index=" + index +
                    ", start=" + start +
                    ", finish=" + finish +
                    '}';
        }

    }

    public static void select(Activity[] activities, int n) {
        // 先按照活动的结束时间排序，collect为排序后的集合
        List<Activity> collect = Arrays.stream(activities)
                .sorted((x, y) -> x.finish - y.finish)
                .collect(Collectors.toList());
        List<Activity> result = new ArrayList<>();
        Activity prev = collect.get(0); // 上次被选中的活动-选择第一个为最先结束的活动（体现贪心思想）
        result.add(prev);
        for (int i = 1; i < n; i++) {
            Activity curr = collect.get(i); // 正在处理的活动
            if (curr.start >= prev.finish) { // 正在处理的活动要在上次选中活动结束之后才开始
                result.add(curr);
                prev = curr;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Activity[] activities = new Activity[]{
                new Activity(2, 0, 6),
                new Activity(1, 3, 4),
                new Activity(0, 1, 2),
                new Activity(4, 8, 9),
                new Activity(3, 5, 7),
                new Activity(5, 5, 9)
        };
        select(activities, activities.length);
    }
}
