package com.training;

//You are a professional robber planning to rob houses along a street.
//        Each house has a certain amount of money stashed, the only constraint stopping you from
//        robbing each of them is that adjacent houses have security systems connected and it will automatically
//        contact the police if two adjacent houses were broken into on the same night.
//
//        Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
//Input: nums = [1,2,3,1]
//        Output: 4
//        Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//        Total amount you can rob = 1 + 3 = 4.
//Input: nums = [2,7,9,3,1]
//        Output: 12
//        Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
//        Total amount you can rob = 2 + 9 + 1 = 12.
//1 <= nums.length <= 100

import com.training.solid.InterfaceSegregationPrinciple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class HouseRobber {

    public static void main(String[] args) {
        System.out.println(dynamicRob().apply(new int[]{1, 2, 3, 1}));
        System.out.println(dynamicRob().apply((new int[] {2,7,9,3,1})));

        System.out.println(rob((new int[] {1, 2, 3, 1})));
        System.out.println(rob((new int[] {2,7,9,3,1})));
    }

    public static Function<int[], Integer> dynamicRob() {
        Map<Integer, Integer> maxCache = new HashMap<>();
        return nums -> rob(nums,   maxCache);
    }

    public static int rob(int[] nums, Map<Integer, Integer>  maxCache) {
        int max = 0;
        for (int i = 0; i < nums.length; i++ ) {
           max = Math.max(robRec(nums, i, maxCache), max);
        }
        return max;
    }

    public static int robRec(int[] nums, int houseIndex, Map<Integer, Integer>  maxCache) {
        if (maxCache.get(houseIndex) != null) {
            return maxCache.get(houseIndex);
        }
        if (nums.length - houseIndex == 1) {
            return nums[houseIndex];
        }
        if (nums.length - houseIndex == 2) {
            return Math.max(nums[houseIndex], nums[houseIndex+1]);
        }
        int remainingMax;
        int nextHouse = houseIndex + 2;
        if (maxCache.get(nextHouse) == null) {
            maxCache.put(nextHouse, robRec(nums, nextHouse, maxCache));
        }
        remainingMax = maxCache.get(nextHouse);
        int max = nums[houseIndex] + remainingMax;
        maxCache.put(houseIndex, max);
        return max;
    }


    public static int rob(int[] nums) {
        int prev1 = 0;
        int prev2 = 0;

        for (final int num : nums) {
            final int dp = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = dp;
        }

        return prev1;
    }
}
