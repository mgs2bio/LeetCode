package com.training;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
//
//        You must write an algorithm that runs in O(n) time.
//
//
//
//        Example 1:
//
//        Input: nums = [100,4,200,1,3,2]
//        Output: 4
//        Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
//        Example 2:
//
//        Input: nums = [0,3,7,2,5,8,4,6,0,1]
//        Output: 9
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        List<Integer> ls = IntStream.of(nums).boxed().collect(Collectors.toList());
        Set<Integer> set = new HashSet<>(ls);
        int max = 1;
        for (int i : set) {
            if (!set.contains(i + 1)) {
                int m = i - 1;
                while (set.contains(m)) {
                    m--;
                }
                max = Math.max(i - m, max);
            }
        }
        return max;
    }
}
