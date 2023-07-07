package com.training;

import java.util.stream.IntStream;

//Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
public class MissingNumber {

    public int missingNumber(int[] nums) {
        return IntStream.range(0, nums.length+1).sum() - IntStream.of(nums).sum();
    }
}
