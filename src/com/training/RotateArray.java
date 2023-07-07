package com.training;

public class RotateArray {

    public static void main(String[] args) {
        rotate(new int[] {1, 2, 3, 4, 5, 6, 7}, 54944);
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= nums.length;
        if(n<k) return;
        reverse(0,n-1, nums);
        reverse(0,k-1, nums);
        reverse(k,n-1, nums);
    }
    public static void reverse(int i, int j, int [] nums){
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j]= temp;
            i++;j--;
        }
    }
}
