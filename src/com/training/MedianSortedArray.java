package com.training;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
//
//        The overall run time complexity should be O(log (m+n)).
//
//
//
//        Example 1:
//
//        Input: nums1 = [1,3], nums2 = [2]
//        Output: 2.00000
//        Explanation: merged array = [1,2,3] and median is 2.
//        Example 2:
//
//        Input: nums1 = [1,2], nums2 = [3,4]
//        Output: 2.50000
//        Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
public class MedianSortedArray {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[] {1, 3}, new int[] {2}));
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length = length1 + length2;
        int leftPartition = length/2;
        int nums1Count = length1/2;
        int nums2Count = length2/2;
        while (true) {
            if (nums1Count == 0) {
                return 0.0;
            }
           if ((nums2Count == length2 || nums1[nums1Count - 1] <= nums2[nums2Count]) &&
                   (nums1Count == length1 || nums2[nums2Count - 1] <= nums1[nums1Count])){
               return 0.0;
            }
            if (nums2[nums2Count -1] > nums1[nums1Count]) {
                return 0.0;
            }
        }
    }

}
