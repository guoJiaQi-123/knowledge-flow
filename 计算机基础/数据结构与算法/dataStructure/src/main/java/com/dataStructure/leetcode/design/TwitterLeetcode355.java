package com.dataStructure.leetcode.design;

import java.util.*;

/**
 * @author OldGj 2024/03/07
 * @version v1.0
 * @apiNote 355. 设计推特
 */
public class TwitterLeetcode355 {

    // 推特类
    static class Twitter {
        // 用户集合
        Map<Integer, User> userMap = new HashMap<>();

        private int time;

        // 创建推文
        public void postTweet(int userId, int tweetId) {
            User user = userMap.computeIfAbsent(userId, User::new);
            user.head.next = new Tweet(tweetId, time++, user.head.next);
        }



        // 获取十条推文
        public List<Integer> getNewsFeed(int userId) {
            User user = userMap.get(userId);
            if (user == null) {
                return List.of();
            }
            // 大顶堆
            PriorityQueue<Tweet> queue = new PriorityQueue<>(
                    Comparator.comparingInt(Tweet::getTime).reversed()
            );
            if (user.head.next != null) {
                queue.offer(user.head.next);
            }
            for (Integer id : user.followee) {
                User followee = userMap.get(id);
                if(followee.head.next != null) {
                    queue.offer(followee.head.next);
                }
            }
            List<Integer> res = new ArrayList<>();
            int count = 0;
            while (!queue.isEmpty() && count < 10) {
                Tweet max = queue.poll();
                res.add(max.tweetId);
                if (max.next != null) {
                    queue.offer(max.next);
                }
                count++;
            }
            return res;
        }

        // 关注
        public void follow(int followerId, int followeeId) {
            User follower = userMap.computeIfAbsent(followerId, User::new);
            User followee = userMap.computeIfAbsent(followeeId, User::new);
            follower.followee.add(followee.id);
        }

        // 取消关注
        public void unfollow(int followerId, int followeeId) {
            User follower = userMap.computeIfAbsent(followerId, User::new);
            User followee = userMap.computeIfAbsent(followeeId, User::new);
            follower.followee.remove(followee.id);
        }

        // 推文类
        static class Tweet {

            // 推文id
            private final int tweetId;
            // 推文创建时间
            private final int time;
            // 使用链表数据结构构建推文
            private Tweet next;

            public Tweet(int tweetId, int time, Tweet next) {
                this.tweetId = tweetId;
                this.time = time;
                this.next = next;
            }

            public int getTime() {
                return time;
            }

            public int getTweetId() {
                return tweetId;
            }
        }

        // 用户类
        static class User {
            // 用户ID
            private final int id;

            public User(int id) {
                this.id = id;
            }

            // 用户拥有的推文
            private final Tweet head = new Tweet(-1, -1, null);

            // 用户关注的人
            Set<Integer> followee = new HashSet<>();
        }
    }
}
