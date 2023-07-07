package com.training;


//There is an integer array nums sorted in ascending order (with distinct values).
//
//        Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
//
//        Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
//
//        You must write an algorithm with O(log n) runtime complexity.
//
//
//
//        Example 1:
//
//        Input: nums = [4,5,6,7,0,1,2], target = 0
//        Output: 4
//        Example 2:
//
//        Input: nums = [4,5,6,7,0,1,2], target = 3
//        Output: -1
//        Example 3:
//
//        Input: nums = [1], target = 0
//        Output: -1
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
//        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
//        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 7));
//        System.out.println(search(new int[]{1}, 0));
//        System.out.println(search(new int[]{1, 3, 5}, 1));
        System.out.println(search(new int[]{5, 1, 3}, 3));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }


    public static int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0;
        int r = nums.length - 1;
        while (true) {
            if (r - l == 1) {
                int index = -1;
                if (nums[l] == target) {
                    index = l;
                }
                if (nums[r] == target) {
                    index = r;
                }
                return index;
            }
            final int mid = (l + r) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[l] > nums[mid]) {
                if (target < nums[mid]) {
                    r = mid;
                }
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid;
                }
                if (target > nums[r]) {
                    r = mid;
                }
                continue;
            }
            if (target > nums[mid]) {
                l = mid;
            }
            if (target < nums[mid] && target >= nums[l]) {
                r = mid;
            }
            if (target < nums[l]) {
                l = mid;
            }
        }

    }
}
