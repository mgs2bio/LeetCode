package com.training;

//Given an integer array nums, find a
//        subarray
//        that has the largest product, and return the product.
//
//        The test cases are generated so that the answer will fit in a 32-bit integer.
//        Example 1:
//
//        Input: nums = [2,3,-2,4]
//        Output: 6
//        Explanation: [2,3] has the largest product 6.
//        Example 2:
//
//        Input: nums = [-2,0,-1]
//        Output: 0
//        Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
public class MaximumProductSubarray {

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct(new int[]{-2, 0, -1}));
        System.out.println(maxProduct(new int[]{-4, -3, -2}));
        System.out.println(maxProduct(new int[]{-2, 3, -4}));
        System.out.println(maxProduct(new int[]{2, -1, 1, 1}));
    }

    public static int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int result = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            final int preMax = currentMax;
            final int preMin = currentMin;
            if (nums[i] < 0) {
                currentMax = Math.max(preMin * nums[i], nums[i]);
                currentMin = Math.min(preMax * nums[i], nums[i]);
            } else {
                currentMax = Math.max(preMax * nums[i], nums[i]);
                currentMin = Math.min(preMin * nums[i], nums[i]);
            }
            result = Math.max(result, currentMax);
        }
        return result;
    }
}
