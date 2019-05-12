package com.lpcoder.guide.stackAndQueue;

/**
 * @author liurenpeng
 * @date Created in 19-4-15
 */
public class MaxSonArray {

    // 问题： 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

    // 思路： 假设sum<=0，那么后面的子序列肯定不包含目前的子序列，所以令sum = num；
    // 如果sum > 0对于后面的子序列是有好处的。res = Math.max(res, sum)保证可以找到最大的子序和。

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        //int[] nums = {-2, -1, -3, -4, -1, -2, -1, -5, -4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;
    }

}
