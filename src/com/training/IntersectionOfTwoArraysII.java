package com.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

//Given two integer arrays nums1 and nums2, return an array of their intersection.
//        Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.


public class IntersectionOfTwoArraysII {

    public static void main(String[] args) {
//        int[] result = intersect1(new int[]{1, 2, 2, 1}, new int[]{2, 2});
//        IntStream.of(result).forEach(System.out::println);
//        int[] result2 = intersect1(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
//        IntStream.of(result2).forEach(System.out::println);

        String[] arr = new String[]{};
        System.out.println(arr.length);
    }

    public static int[] intersect1(int[] num1, int[] num2) {
        Arrays.sort(num1);
        Arrays.sort(num2);
        List<Integer> intersection = new ArrayList<>();
        int i = 0, j = 0;
        while (true) {
            if (i >= num1.length || j >= num2.length) {
                break;
            }
            if (num1[i] == num2[j]) {
                intersection.add(num1[i]);
                i++;
                j++;
                continue;
            }
            if (num1[i] < num2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return intersection.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> ls = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                ls.add(nums1[i]);
                i++;
                j++;
                continue;
            }
            if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return ls.stream().mapToInt(Integer::intValue).toArray();
    }
}
