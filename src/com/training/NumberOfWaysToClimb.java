package com.training;

//There's a staircase with N steps, and you can climb 1 or 2 steps at a time.
//        Given N, write a function that returns the number of unique ways you can climb the staircase.
//        The order of the steps matters.
//
//        For example, if N is 4, then there are 5 unique ways:
//
//        1, 1, 1, 1
//
//        2, 1, 1
//
//        1, 2, 1
//
//        1, 1, 2
//
//        2, 2
//
//        What if, instead of being able to climb 1 or 2 steps at a time,
//        you could climb any number from a set of positive integers X? For example, if X = {1, 3, 5},
//        you could climb 1, 3, or 5 steps at a time. Generalize your function to take in X.
public class NumberOfWaysToClimb {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 3, 5}, 5));
    }

    private static int solution(int[] steps, int total) {
        if (total == 0) {
            return 0;
        }
        Integer[] pd = new Integer[total];
        return solutionPd(steps, total, pd);
    }

    private static int solutionPd(int[] steps, int total, Integer[] pd ) {
        if (total == 0 || total == steps[0]) {
            return 1;
        }
        if (total < steps[0]) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i< steps.length; i++) {
            int remaining = total - steps[i];
            if (remaining >= 0) {
                if (pd[remaining] != null) {
                    sum += pd[remaining];
                } else {
                    int num = solutionPd(steps, remaining, pd);
                    pd[remaining] = num;
                    sum += num;
                }
            }
        }
        return sum;
    }



}
