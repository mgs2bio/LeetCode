package com.training;

import com.training.solid.InterfaceSegregationPrinciple;

import java.util.stream.IntStream;

//Given an integer array nums, find the subarray with the largest sum, and return its sum.
//Example 1:
//
//        Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//        Output: 6
//        Explanation: The subarray [4,-1,2,1] has the largest sum 6.
public class MaximumSubarray {


    public static void main(String[] args) throws Exception {
        System.out.println(maxSubArray1(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray1(new int[]{5, 4, -1, 7, 8}));
        System.out.println(maxSubArray1(new int[]{1}));
        System.out.println(maxSubArray1(new int[]{-2, 1}));
    }


    private static long maxSubArray1(int[] arr) throws Exception {
        if (arr.length == 0) {
            throw new Exception();
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            max = Math.max(sum, max);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }


    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            int pre = current + nums[i];
            current = Math.max(pre, 0);
            max = Math.max(pre, max);
        }
        return max;
    }


}
