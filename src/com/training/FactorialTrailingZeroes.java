package com.training;

//Given an integer n, return the number of trailing zeroes in n!.
//
//        Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
//
//
//
//        Example 1:
//
//        Input: n = 3
//        Output: 0
//        Explanation: 3! = 6, no trailing zero.
//        Example 2:
//
//        Input: n = 5
//        Output: 1
//        Explanation: 5! = 120, one trailing zero.
//        Example 3:
//
//        Input: n = 0
//        Output: 0
//write a solution that works in logarithmic time complexity
public class FactorialTrailingZeroes {

    public static void main(String[] args) {
        System.out.println(trailingZeroes(30));
    }

    public static int trailingZeroes(int n) {
        int i = 1, result = 0;
        while (n >= Math.pow(5, i)) {
            result = result + n / (int) Math.pow(5, i);
            i++;
        }
        return result;
    }
}
