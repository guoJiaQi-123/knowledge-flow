package com.dataStructure.algorithm.exhaustion;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 322. 零钱兑换
 */
public class Leetcode322 {
    static int min = -1;

    public int coinChange(int[] coins, int amount) {
        rec(0, coins, amount, new AtomicInteger(-1));
        return min;
    }


    private void rec(int index, int[] coins, int remainder, AtomicInteger count) {
        count.incrementAndGet();
        if (remainder == 0) {
            if (min == -1) {
                min = count.get();
            } else {
                min = Integer.min(min, count.get());
            }
        }else if(remainder >0){
            for (int i = index; i < coins.length; i++) {
                rec(i,coins, remainder -coins[i], count);
            }
        }
        count.decrementAndGet();
    }

    public static void main(String[] args) {
        Leetcode322 leetcode322 = new Leetcode322();
        int i = leetcode322.coinChange(new int[]{2}, 3);
        System.out.println(i);
    }
}
