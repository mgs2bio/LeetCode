package com.training;

//Given an integer array nums where the elements are sorted in ascending order, convert it to a
//        height-balanced
//        binary search tree.
public class SortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        TreeNode rn = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(rn);
        TreeNode rn1 = sortedArrayToBST(new int[]{1, 3});
        System.out.println(rn1);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        int mid = nums.length / 2;
        TreeNode right = sortedArrayToBST(nums, mid + 1, nums.length - 1);
        TreeNode left = sortedArrayToBST(nums, 0, mid - 1);
        return new TreeNode(nums[mid], left, right);
    }

    public static TreeNode sortedArrayToBST(int[] nums, int i, int j) {
        if (i == j) {
            return new TreeNode(nums[j]);
        }
        if (i > j) {
            return null;
        }
        int mid = (i + j) / 2;
        TreeNode right = sortedArrayToBST(nums, mid + 1, j);
        TreeNode left = sortedArrayToBST(nums, i, mid - 1);
        return new TreeNode(nums[mid], left, right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
