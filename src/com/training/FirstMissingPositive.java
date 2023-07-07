package com.training;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Given an unsorted integer array nums, return the smallest missing positive integer.
//
//        You must implement an algorithm that runs in O(n) time and uses constant extra space.
//
//Example 1:
//
//        Input: nums = [1,2,0]
//        Output: 3
//        Explanation: The numbers in the range [1,2] are all in the array.
//        Example 2:
//
//        Input: nums = [3,4,-1,1]
//        Output: 2
//        Explanation: 1 is in the array but 2 is missing.
//        Example 3:
//
//        Input: nums = [7,8,9,11,12]
//        Output: 1
//        Explanation: The smallest positive integer 1 is missing.
public class FirstMissingPositive {
    public static void main(String[] args) {
//        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
//        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
//        System.out.println(firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
//        System.out.println(firstMissingPositive(new int[]{1, 2, 3, 10, 2147483647, 9}));
        System.out.println(firstMissingPositive(new int[]{2147483647, 2147483646, 2147483645, 3, 2, 1, -1, 0, -2147483648}));
    }

    public static int firstMissingPositive(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        if (max <= 0) {
            return 1;
        }
        OptionalInt minOpt = Arrays.stream(nums).filter(i -> i > 0).min();
        if (minOpt.isPresent() && minOpt.getAsInt() > 1) {
            return 1;
        }
        int positiveMin = minOpt.getAsInt();
        List<Integer> ls = IntStream.of(nums).boxed().collect(Collectors.toList());
        positiveMin++;
        while (positiveMin <= Integer.MAX_VALUE && ls.contains(positiveMin)) {
            positiveMin++;
        }
        ;
        return positiveMin - 1;
    }
}
