package com.dataStructure.algorithm.divideandconquer;

/**
 * @author OldGj 2024/02/28
 * @version v1.0
 * @apiNote 69. x 的平方根
 */
public class SqrtLeetcode69 {
    /*
        99 = 9.?

        1*1 = 1  10 次
        2*2 = 4
        ...
        9*9 = 81
        10*10 = 100


        x=99

        i j  m
        1 99 50  6 次
        1 49 25
        1 24 12
        1 11 6
        7 11 9
        10 11 10
     */
    public int mySqrt(int x) {
        int i = 1;
        int j = x;
        int n = 0;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (x / m >= m) {
                i = m + 1;
                n = m;
            } else {
                j = m - 1;
            }
        }
        return n;
    }
}
