package com.training;

//You are climbing a staircase. It takes n steps to reach the top.
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//
//        Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//Input: n = 2
//        Output: 2
//        Explanation: There are two ways to climb to the top.
//        1. 1 step + 1 step
//        2. 2 steps
public class ClimbingStairs {

    public static void main(String[] args) {

        System.out.println(climbStairs(3));

    }

    public static int climbStairs(int n) {
        Integer[] memo = new Integer[n];
        return climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
    }

    public static int climbStairs(int n, Integer[] memo) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        Integer oneFirst = memo[n - 1];
        if (oneFirst == null) {
            oneFirst = climbStairs(n - 1, memo);
            memo[n - 1] = oneFirst;
        }
        Integer secondFirst = memo[n - 2];
        if (secondFirst == null) {
            secondFirst = climbStairs(n - 2, memo);
            memo[n - 2] = secondFirst;
        }
        return oneFirst + secondFirst;
    }
}
