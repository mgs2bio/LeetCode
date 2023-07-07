package com.training;

import java.util.Arrays;
import java.util.stream.IntStream;

//A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
//
//        For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
//        The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
//
//        For example, the next permutation of arr = [1,2,3] is [1,3,2].
//        Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
//
//Example 1:
//
//        Input: nums = [1,2,3]
//        Output: [1,3,2]
//        Example 2:
//
//        Input: nums = [3,2,1]
//        Output: [1,2,3]
//        Example 3:
//
//        Input: nums = [1,1,5]
//        Output: [1,5,1]

public class NextPermutation {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));

    }


    public static void nextPermutation(int[] nums) {
        int pivot = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                int j = pivot + 1;
                while (j <= nums.length - 1 && nums[j] > nums[pivot]) {
                    j++;
                }
                swap(nums, j - 1, pivot);
                reverse(nums, pivot + 1);
                break;
            }
            if (i == 0) {
                Arrays.sort(nums);
            }
        }
    }

    private static void reverse(int[] nums, int j) {
        int i = j, k = nums.length - 1;
        while (i < k) {
            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
            i++;
            k--;
        }
    }

    private static void swap(int[] nums, int j, int pivot) {
        int temp = nums[j];
        nums[j] = nums[pivot];
        nums[pivot] = temp;
    }
}
