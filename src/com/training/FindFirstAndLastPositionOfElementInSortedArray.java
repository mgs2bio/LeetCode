package com.training;

//
//Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
//
//        If target is not found in the array, return [-1, -1].
//
//        You must write an algorithm with O(log n) runtime complexity.
//Example 1:
//
//        Input: nums = [5,7,7,8,8,10], target = 8
//        Output: [3,4]
//        Example 2:
//
//        Input: nums = [5,7,7,8,8,10], target = 6
//        Output: [-1,-1]
//        Example 3:
//
//        Input: nums = [], target = 0
//        Output: [-1,-1]

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[]{0, 0};
            }
            return new int[]{-1, -1};
        }
        int[] ans = new int[2];
        ans[0] = bstToLeft(nums, target, 0, nums.length - 1);
        ans[1] = bstToRight(nums, target, 0, nums.length - 1);
        return ans;
    }

    private static int bstToLeft(int[] nums, int target, int left, int right) {
        if (right - left == 1) {
            if (nums[left] == target) {
                return left;
            }
            if (nums[right] == target) {
                return right;
            }
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = nums[mid];
        if (target <= midVal) {
            return bstToLeft(nums, target, left, mid);
        }
        return bstToLeft(nums, target, mid, right);
    }

    private static int bstToRight(int[] nums, int target, int left, int right) {
        if (right - left == 1) {
            if (nums[right] == target) {
                return right;
            }
            if (nums[left] == target) {
                return left;
            }
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = nums[mid];
        if (target >= midVal) {
            return bstToRight(nums, target, mid, right);
        }
        return bstToRight(nums, target, left, mid);
    }
}
