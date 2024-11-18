package com.dataStructure.algorithm.divideandconquer;

/**
 * @author OldGj 2024/02/27
 * @version v1.0
 * @apiNote 快速幂
 */
public class QuickRowLeetcode50 {


    public double myPow(double x, int n) {
        // 定义一个指针记录幂次方
        long p = n;
        // 如果幂次方为负数，则先转为整数进行计算，输出计算结果的倒数即可
        if (p < 0) {
            p = -p;
        }
        double v = myPowPositive(x, p);
        // 如果幂次方为负，则返回结果倒数
        return n < 0 ? 1 / v : v;
    }

    public double myPowPositive(double x, long n) {
        /*
                x^n
                2^10
             2^5   2^5
         */
        if (n == 0) { // x ^ 0 = 1
            return 1.0;
        }
        if (n == 1) { // x ^ 1 = x
            return x;
        }
        double y = myPowPositive(x, n / 2); // y = x ^ 5
        if ((n & 1) == 0) { // 偶数  n == 10 为偶数
            return y * y;  // 返回 x^5 * x^5 == x^10
        } else { // 奇数   // n == 5 为奇数
            return x * y * y; // 返回 x * x^2 * x^2 == x^5
        }
    }
}
