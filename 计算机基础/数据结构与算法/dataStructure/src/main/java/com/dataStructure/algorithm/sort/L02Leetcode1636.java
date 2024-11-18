package com.dataStructure.algorithm.sort;

import java.util.Arrays;

/**
 * 1636. 按照频率将数组升序排序
 */
public class L02Leetcode1636 {

    /**
     * 对整数数组进行频率排序
     *
     * @param nums 被排序的数组
     * @return 排序后的数组
     */
    public int[] frequencySort(int[] nums) {

        //创建一个数组，用于记录每个数字出现的次数
        int[] count = new int[201];
        for (int num : nums) {

            //将每个数字出现的次数记录到count数组中
            count[num+100]++;
        }
        //使用Arrays.stream()方法将nums数组转换为IntStream，然后使用sorted()方法对其进行排序，sortOrder为自然顺序
        //注意，这里使用了lambda表达式来定义排序规则
        return Arrays.stream(nums).boxed().sorted((a,b)->{

            //获取数字a和b出现的次数
            int af = count[a+100];
            int bf = count[b+100];
            if(af>bf){
                //如果数字a出现的次数大于数字b出现的次数，则返回1
                return 1;
            }else if(af<bf) {
                //如果数字a出现的次数小于数字b出现的次数，则返回-1
                return -1;
            }else {

                //如果数字a和b出现的次数相等，则比较它们的大小
                return b-a;
            }
        }).mapToInt(Integer::intValue).toArray();
    }
}
