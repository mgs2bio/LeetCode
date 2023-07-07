package com.training;


//You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
//
//        Find two lines that together with the x-axis form a container, such that the container contains the most water.
//
//        Return the maximum amount of water a container can store.
//
//        Notice that you may not slant the container.
//Input: height = [1,8,6,2,5,4,8,3,7]
//        Output: 49
//        Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
//        Example 2:
//
//        Input: height = [1,1]
//        Output: 1

public class ContainerWithMostWater {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int preL = left;
        int preR = right;
        int maxArea = maxArea(left, right, height);
        while (left < right) {
            if (height[left] < height[right]) {
                left++;
                while (height[preL] >= height[left] && left < right) {
                    left++;
                }
                preL = left;
            } else {
                right--;
                while (height[preR] >= height[right] && right > left) {
                    right--;
                }
                preR = right;
            }
            maxArea = Math.max(maxArea, maxArea(left, right, height));
        }
        return maxArea;

    }

    private static int maxArea(int lIndex, int rIndex, int[] height) {
        return Math.min(height[lIndex], height[rIndex]) * (rIndex - lIndex);
    }
}
