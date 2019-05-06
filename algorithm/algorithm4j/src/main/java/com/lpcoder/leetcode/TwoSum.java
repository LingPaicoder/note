package com.lpcoder.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

import javafx.util.Pair;

/**
 * @author liurenpeng
 * @date Created in 19-4-21
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        int[] rst = twoSum(arr, 9);
        for (int i = 0; i < rst.length; i++) {
            System.out.println(rst[i]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else {
                map.put(target - nums[i], i);
            }
        }
        return new int[2];
    }

}
