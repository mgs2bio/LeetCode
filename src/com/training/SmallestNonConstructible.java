package com.training;

//Given an array of positive integers (representing coins), find the smallest value that cannot be constructed from those integers.
//        Reference: Elements of Programming Interviews in python, page 189
//        Example 1:
//        Input: A = [1, 2, 4]
//        Output: 8
//        Explanation: With subsets of A, we can construct values 1, 2, 3, 4, 5, 6, 7.
//        Example 2:
//        Input: A = [1, 2, 5]
//        Output: 4
//        Explanation: With subsets of A, we can construct values 1, 2, 3, 5, 6, 7, 8.

import java.util.Arrays;

public class SmallestNonConstructible {

    public static void main(String[] args) {

    }

    public static int solution(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] > 1) {
            return 1;
        }
        int current = nums[0] + 1;
        int previous = nums[0] + 1;
        for (int i = 1; i < nums.length; i++) {
            current = previous + nums[i];
        }
        return current;
    }
}
